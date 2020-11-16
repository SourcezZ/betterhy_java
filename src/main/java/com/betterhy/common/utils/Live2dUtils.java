package com.betterhy.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

/**
 * Live2D 工具类
 *
 * @author Source
 * @date 2020-11-16 16:58
 **/
public class Live2dUtils {

    private static final String[] MODEL_TYPE = new String[]{"bilibili-live", "HyperdimensionNeptunia", "KantaiCollection", "Potion-Maker", "ShizukuTalk"};
    private static final String PATH = "/root/prod/betterhy_vue/dist/static/live2d_2/live2d_api/model/";

    public static Map<String, List<String>> getModelMap(String path) {
        Queue<String> queue = new LinkedList<String>() {{
            add(path);
        }};
        Map<String, List<String>> modelMap = new HashMap<>();
        while (!queue.isEmpty()) {
            String dirPath = queue.poll();
            // 获得指定文件对象
            File file = new File(dirPath);
            // 获得该文件夹内的所有文件
            File[] array = file.listFiles();
            assert array != null;
            for (File value : array) {
                if (value.isFile()) {
                    String name = value.getName();
                    if ("index.json".equals(name)) {
                        String url = value.getAbsolutePath().replace('\\', '/');
                        String modelId = url.replaceAll(".*/model/", "").split("/")[0];
                        String modelTexturesId = url.replaceAll(".*/model/", "").split("/")[1];
                        List<String> subList = modelMap.computeIfAbsent(modelId, k -> new ArrayList<>());
                        subList.add(modelTexturesId);
                    }
                } else if (value.isDirectory()) {
                    queue.add(value.getAbsolutePath());
                }
            }
        }
        return modelMap;
    }

    public static Map<String, Object> getLive2D(Map<String, Object> reqMap) {
        int modelId;
        int modelTexturesId;
        Map<String, List<String>> modelMap = getModelMap(PATH);
        Random random = new Random();
        String isRandom = (String) reqMap.get("isRandom");
        if ("1".equals(isRandom)){
            modelId = random.nextInt(MODEL_TYPE.length);
            modelTexturesId = random.nextInt(modelMap.get(MODEL_TYPE[modelId]).size());
        }else {
            modelId = Integer.parseInt((String) reqMap.get("modelId"));
            modelTexturesId = Integer.parseInt((String) reqMap.get("modelTexturesId"));
        }
        String url = (String) reqMap.get("defaultUrl");

        if (url != null){
            Map<String, Object> map = new HashMap<>();
            map.put("url", url);
            map.put("modelId", modelId);
            map.put("modelTexturesId", modelTexturesId);
            return map;
        }

        String modelIdUrl = MODEL_TYPE[modelId];
        String modelTexturesIdUrl = modelMap.get(modelIdUrl).get(modelTexturesId);

        url = "./static/live2d_2/live2d_api/model/" + modelIdUrl + "/" + modelTexturesIdUrl + "/index.json";
        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
        map.put("modelId", modelId);
        map.put("modelTexturesId", modelTexturesId);
        return map;
    }

    public static Map<String, Object> getRandJson(Map<String, Object> reqMap) {
        int modelId;
        int modelTexturesId;
        try {
            modelId = Integer.parseInt((String) reqMap.get("modelId"));
            modelTexturesId = Integer.parseInt((String) reqMap.get("modelTexturesId"));
        } catch (Exception e){
            modelId = 0;
            modelTexturesId = 0;
        }


        Map<String, List<String>> modelMap = getModelMap(PATH);

        String modelIdUrl = MODEL_TYPE[modelId];
        String modelTexturesIdUrl = modelMap.get(modelIdUrl).get(modelTexturesId);

        String url;
        Random random = new Random();
        if (modelId == 1 || modelId == 4) {
            List<String> modelList = modelMap.get(modelIdUrl);
            modelTexturesId = random.nextInt(modelList.size());
            String randModelTexturesIdUrl = modelList.get(modelTexturesId);
            url = "./static/live2d_2/live2d_api/model/" + modelIdUrl + "/" + randModelTexturesIdUrl + "/index.json";
        } else {
            try {
                String randomUrl = PATH + modelIdUrl + "/" + modelTexturesIdUrl + "/randomJson/";
                File[] files = new File(randomUrl).listFiles();
                assert files != null;
                File file = files[random.nextInt(files.length)];
                url = file.getAbsolutePath().replace("/root/prod/betterhy_vue/dist", ".");
            } catch (Exception e) {
                List<String> modelList = modelMap.get(modelIdUrl);
                String randModelTexturesIdUrl = modelList.get(random.nextInt(modelList.size()));
                url = "./static/live2d_2/live2d_api/model/" + modelIdUrl + "/" + randModelTexturesIdUrl + "/index.json";
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("url", url);
        map.put("modelId", modelId);
        map.put("modelTexturesId", modelTexturesId);
        return map;
    }


    public static void main(String[] args) {
        //这是需要获取的文件夹路径
        String path = "D:\\Subject\\betterhy\\betterhy_vue\\dist\\static\\live2d_2\\live2d_api\\model";
//        getModelMap(path);
//        System.out.println(getRandJson());
    }
}
