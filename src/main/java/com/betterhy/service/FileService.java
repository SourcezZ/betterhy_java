package com.betterhy.service;

import com.betterhy.common.constant.Dict;
import com.betterhy.common.result.Result;
import com.betterhy.common.result.ResultFactory;
import com.betterhy.common.utils.OaUtils;
import com.github.pagehelper.util.StringUtil;
import com.google.common.collect.Maps;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 文件服务
 *
 * @author Source
 * @date 2020-09-13 11:21
 **/
@Service
public class FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Value("${file.upload.path}")
    private String fileRootPath;

    public Result upload(Map<String, Object> reqMap, MultipartFile file) {
        if (file.isEmpty()) {
            return ResultFactory.buildFailResult("上传失败，不能上传空文件");
        }

        //小程序无法获取文件原始名字，让用户重新命名
        String fileName = (String) reqMap.get(Dict.FILE_NAME);
        if (StringUtil.isEmpty(fileName)) {
            return ResultFactory.buildFailResult("上传失败，文件名不能为空");
        }

        String absolutePath = new File(fileRootPath).getAbsolutePath() + "/";

        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? absolutePath : absolutePath + path;

        File staticPath = new File(absolutePath);
        if (!staticPath.exists()) {
            boolean mk = staticPath.mkdirs();
            logger.info(mk ? "创建路径成功" : "创建路径失败");
        }
        File dest = new File(path + fileName);
        if (dest.exists()) {
            fileName = OaUtils.renameUploadFileName(fileName);
            dest = new File(absolutePath + fileName);
            logger.info("同名文件已存在，用时间后辍重命名新文件");
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return ResultFactory.buildSuccessResult("上传成功");
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return ResultFactory.buildFailResult("上传失败");
    }

    public String downLoad(Map<String, Object> reqMap, HttpServletResponse res) {
        Map<String, Object> reMap = Maps.newHashMapWithExpectedSize(2);
        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? fileRootPath : fileRootPath + path;

        String fileName = (String) reqMap.get("fileName");
        //要下载的文件地址 可以通过形参传进来
        String filepath = path + fileName;

        // 读取流
        File f = new File(filepath);
        if (!f.exists()) {
            reMap.put("returnMsg", "下载附件失败，文件不存在");
            reMap.put("returnCode", 404);
            return JSONObject.fromObject(reMap).toString();
        }

        OutputStream os = null;
        InputStream is = null;
        try {
            // 取得输出流
            os = res.getOutputStream();
            // 清空输出流
            res.reset();
            res.setContentType("application/x-download;charset=GBK");
            res.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            is = new FileInputStream(f);
            // 复制
            IOUtils.copy(is, res.getOutputStream());
            res.getOutputStream().flush();
        } catch (IOException e) {
            reMap.put("returnCode", 404);
            reMap.put("returnMsg", "下载附件失败,error:" + e.getMessage());
        }
        // 文件的关闭放在finally中
        finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                logger.error(e.toString());
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                logger.error(e.toString());
            }
        }
        return JSONObject.fromObject(reMap).toString();
    }

    public Result deleteFile(Map<String, Object> reqMap) {
        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? fileRootPath : fileRootPath + path;
        List<String> deleteList = OaUtils.castList(reqMap.get("list"), String.class);
        if (deleteList == null || deleteList.isEmpty()) {
            return ResultFactory.buildFailResult("未选择要删除的文件");
        }
        Map<String, Object> resMap = Maps.newHashMapWithExpectedSize(deleteList.size());
        for (String filename : deleteList) {
            String filePath = path + filename;
            File file = new File(filePath);
            if (file.exists()) {
                boolean deleteSuccess = file.delete();
                resMap.put("count", deleteSuccess ? 1 : 0);
                if (!deleteSuccess && file.isDirectory()) {
                    return ResultFactory.buildFailResult("文件夹内有文件，不允许删除");
                }
            } else {
                resMap.put("count", 0);
            }
        }
        return ResultFactory.buildSuccessResult(resMap);
    }

    public Result showFile(Map<String, Object> reqMap) {
        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? fileRootPath : fileRootPath + path;
        File file = new File(path);
        if (!file.exists()) {
            return ResultFactory.buildFailResult(path + " not exists");
        }

        List<String> fileList = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && f2.isFile()) {
                    return -1;
                }
                if (f1.isFile() && f2.isDirectory()) {
                    return 1;
                }
                long diff = f1.lastModified() - f2.lastModified();
                if (diff > 0) {
                    return 1;
                } else if (diff == 0) {
                    return 0;
                } else {
                    return -1;
                }
            });
            for (File fs : files) {
                if (fs.isDirectory()) {
                    fileList.add(fs.getName() + "-directory");
                } else {
                    fileList.add(fs.getName());
                }
            }
        }

        return ResultFactory.buildSuccessResult(fileList);
    }

    public Result newFilePath(Map<String, Object> reqMap) {
        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? fileRootPath : fileRootPath + path;
        String docName = (String) reqMap.get("docName");
        File file = new File(path + docName);
        if (file.exists()) {
            return ResultFactory.buildFailResult("此位置已包含同名文件夹，请重新输入");
        } else {
            return file.mkdir() ? ResultFactory.buildSuccessResult("文件夹创建成功") : ResultFactory.buildFailResult("文件夹创建失败");
        }
    }

    public Result renameFilePath(Map<String, Object> reqMap) {
        String path = (String) reqMap.get("path");
        path = path == null || path.isEmpty() ? fileRootPath : fileRootPath + path;
        String oldName = (String) reqMap.get("oldName");
        String newName = (String) reqMap.get("newName");
        File oldFile = new File(path + oldName);
        File newFile = new File(path + newName);
        if (newFile.exists()) {
            return ResultFactory.buildFailResult("此位置已包含同名文件，请重新输入");
        }
        if (oldFile.exists()) {
            return oldFile.renameTo(newFile) ? ResultFactory.buildSuccessResult("重命名成功") : ResultFactory.buildFailResult("重命名失败");
        } else {
            return ResultFactory.buildFailResult("文件夹或文件已不存在");
        }
    }
}
