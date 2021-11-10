package com.betterhy.common.utils;

import com.aliyun.facebody20191230.models.GenerateHumanAnimeStyleRequest;
import com.aliyun.fileform.models.FileField;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadRequest;
import com.aliyun.openplatform20191219.models.AuthorizeFileUploadResponse;
import com.aliyun.oss.models.PostObjectRequest;
import com.aliyun.tea.TeaConverter;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaPair;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.models.RuntimeOptions;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ViapiFileUtilAdvance {

    private static final String ACCESSKEY = "*";
    private static final String ACCESSKEYSECRET = "*";

    @SneakyThrows
    public static String generateTempUrl(String file) {
        String regionId = "cn-shanghai";
        //String file = "/home/admin/file/1.jpg"; //或者本地上传
//        String file = "https://img.alicdn.com/tfs/TB1S0DjC4v1gK0jSZFFXXb0sXXa-692-440.jpg";
        try (InputStream inputStream = buildInputStream(file)) {
            ViapiFileUtilAdvance fileUtils = ViapiFileUtilAdvance.getInstance(ACCESSKEY, ACCESSKEYSECRET, regionId);
            String ossTempFileUrl = fileUtils.upload(inputStream);
            return ossTempFileUrl;
        }
    }

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.facebody20191230.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "facebody.cn-shanghai.aliyuncs.com";
        return new com.aliyun.facebody20191230.Client(config);
    }
    public static Map<String, Object> generateHumanPicMap(String ossUrl, String type){
        com.aliyun.facebody20191230.Client client = null;
        try {
            client = ViapiFileUtilAdvance.createClient(ACCESSKEY, ACCESSKEYSECRET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GenerateHumanAnimeStyleRequest generateHumanAnimeStyleRequest = new GenerateHumanAnimeStyleRequest()
                .setImageURL(ossUrl)
                .setAlgoType(type);
        // 复制代码运行请自行打印 API 的返回值
        TeaModel teaModel = null;
        try {
            teaModel = client.generateHumanAnimeStyle(generateHumanAnimeStyleRequest);
            return teaModel.toMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream buildInputStream(String filePath) throws IOException {
        if (StringUtils.startsWithAny(filePath, new CharSequence[]{"http://", "https://"})) {
            filePath = URLDecoder.decode(filePath, "UTF-8");
            URL url = new URL(filePath);
            URLConnection urlConnection = url.openConnection();
            return urlConnection.getInputStream();
        } else {
            File key1 = new File(filePath);
            return new FileInputStream(key1);
        }
    }

    public static synchronized ViapiFileUtilAdvance getInstance(String accessKeyId, String accessKeySecret, String regionId) throws Exception {
        String mapKey = String.format("%s:%s:%s", regionId, accessKeyId, accessKeySecret);
        ViapiFileUtilAdvance fileUtils = _map.get(mapKey);
        if (fileUtils == null) {
            _map.putIfAbsent(mapKey, new ViapiFileUtilAdvance(accessKeyId, accessKeySecret, regionId));
            fileUtils = _map.get(mapKey);
        }
        return fileUtils;
    }


    private ViapiFileUtilAdvance(String accessKeyId, String accessKeySecret, String regionId) throws Exception {
        Map<String, Object> cm = new HashMap<>();
        cm.put("regionId", regionId);
        cm.put("autoretry", "true");
        cm.put("accessKeyId", accessKeyId);
        cm.put("accessKeySecret", accessKeySecret);
        cm.put("connectTimeout", 15 * 1000);
        cm.put("readTimeout", 30 * 1000);
        cm.put("maxIdleConns", 200);
        cm.put("type", "access_key");
        cm.put("endpoint", "openplatform.aliyuncs.com");
        _runtime = RuntimeOptions.build(cm);
        com.aliyun.tearpc.models.Config authConfig = com.aliyun.tearpc.models.Config.build(cm);
        _authClient = new com.aliyun.openplatform20191219.Client(authConfig);
        //ossEndpointType = "internal";//aliyun-vpc
        _ossConfig = com.aliyun.oss.models.Config.build(TeaConverter.buildMap(
                new TeaPair("accessKeySecret", accessKeySecret),
                new TeaPair("type", "access_key"),
                new TeaPair("protocol", _authClient._protocol),
                new TeaPair("regionId", _authClient._regionId)
        ));
    }

    public String upload(InputStream inputStream) throws Exception {
        AuthorizeFileUploadRequest authRequest = AuthorizeFileUploadRequest.build(TeaConverter.buildMap(
                new TeaPair("product", "imageseg"),
                new TeaPair("regionId", _authClient._regionId)
        ));
        AuthorizeFileUploadResponse authResponse = _authClient.authorizeFileUploadWithOptions(authRequest, _runtime);
        com.aliyun.oss.models.Config ossConfig = new com.aliyun.oss.models.Config();
        com.aliyun.openapiutil.Client.convert(_ossConfig, ossConfig);
        ossConfig.accessKeyId = authResponse.accessKeyId;
        ossConfig.endpoint = com.aliyun.openapiutil.Client.getEndpoint(authResponse.endpoint, authResponse.useAccelerate, ossEndpointType);
        com.aliyun.oss.Client ossClient = new com.aliyun.oss.Client(ossConfig);
        FileField fileObj = FileField.build(TeaConverter.buildMap(
                new TeaPair("filename", authResponse.objectKey),
                new TeaPair("content", inputStream),
                new TeaPair("contentType", "")
        ));
        PostObjectRequest.PostObjectRequestHeader ossHeader = PostObjectRequest.PostObjectRequestHeader.build(TeaConverter.buildMap(
                new TeaPair("accessKeyId", authResponse.accessKeyId),
                new TeaPair("policy", authResponse.encodedPolicy),
                new TeaPair("signature", authResponse.signature),
                new TeaPair("key", authResponse.objectKey),
                new TeaPair("file", fileObj),
                new TeaPair("successActionStatus", "201")
        ));
        PostObjectRequest uploadRequest = PostObjectRequest.build(TeaConverter.buildMap(
                new TeaPair("bucketName", authResponse.bucket),
                new TeaPair("header", ossHeader)
        ));
        com.aliyun.ossutil.models.RuntimeOptions ossRuntime = new com.aliyun.ossutil.models.RuntimeOptions();
        com.aliyun.openapiutil.Client.convert(_runtime, ossRuntime);
        ossClient.postObject(uploadRequest, ossRuntime);
        String imageURL = "http://" + authResponse.bucket + "." + authResponse.endpoint + "/" + authResponse.objectKey + "";
        return imageURL;
    }

    RuntimeOptions _runtime;
    com.aliyun.openplatform20191219.Client _authClient;
    com.aliyun.oss.models.Config _ossConfig;
    String ossEndpointType = null;
    static Map<String, ViapiFileUtilAdvance> _map = new ConcurrentHashMap<>();

}