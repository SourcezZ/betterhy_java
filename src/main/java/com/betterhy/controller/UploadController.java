package com.betterhy.controller;

import com.betterhy.common.result.Result;
import com.betterhy.service.FileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 上传控制类
 *
 * @author Source
 * @date 2020-08-17 09:45
 **/
@RestController
public class UploadController {

    @Resource
    FileService fileService;

    /**
     * 上传文件
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaUploadFile")
    public Result upload(@RequestParam Map<String, Object> reqMap, @RequestParam("file") MultipartFile file) {
        return fileService.upload(reqMap, file);
    }

    /**
     * 下载文件
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaDownloadFile")
    public String downLoad(@RequestBody Map<String, Object> reqMap, HttpServletResponse res) {
        return fileService.downLoad(reqMap, res);
    }

    /**
     * 删除文件或文件夹
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaDeleteFile")
    public Result deleteFile(@RequestBody Map<String, Object> reqMap) {
        return fileService.deleteFile(reqMap);
    }

    /**
     * 展示文件夹
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaShowFilePath")
    public Result showFile(@RequestBody Map<String, Object> reqMap){
        return fileService.showFile(reqMap);
    }

    /**
     * 新建文件夹
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaNewFilePath")
    public Result newFilePath(@RequestBody Map<String, Object> reqMap){
        return fileService.newFilePath(reqMap);
    }

    /**
     * 重命名文件夹
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/oaRenameFilePath")
    public Result renameFilePath(@RequestBody Map<String, Object> reqMap){
        return fileService.renameFilePath(reqMap);
    }
}
