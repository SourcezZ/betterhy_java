package com.betterhy.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 微信推送工具类
 *
 * @author Source
 * @date 2022-05-20 14:49:50
 */
public class WxPusherUtils {
    private static final Logger logger = LoggerFactory.getLogger("WxPusherUtils");
    private static final String SEND_URL = "http://wxpusher.zjiecode.com/api/send/message/";
    private static final String GET_RESULT_URL = "http://wxpusher.zjiecode.com/api/send/query/";
    private static final String APP_TOKEN = "AT_59NZsHysU0xud3ZTZqlA0lw5tIOTl8K5";
    public static void pushMsg(String msg) {
        Map<String, Object> params = new HashMap<String, Object>(16){
            {
                put("appToken", APP_TOKEN);
                put("content", msg);
                put("summary", msg); //消息摘要，显示在微信聊天页面或者模版消息卡片上，限制长度100，可以不传，不传默认截取content前面的内容。
                put("contentType", 1); // 内容类型 1表示文字  2表示html(只发送body标签内部的数据即可，不包括body标签) 3表示markdown
                put("topicIds", new int[]{5946});//发送目标的topicId，是一个数组！！！，也就是群发，使用uids单发的时候， 可以不传。
                put("uids", new int[]{});
                put("url", "https://www.betterhy.com");
            }
        };
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("pushWxMsg-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
        executor.execute(() ->{
            try {
                String res = HttpRequest.sendPost(SEND_URL, JSON.toJSONString(params));
                logger.info(res);
                int messageId = (int) ((JSONObject)((JSONArray) JSON.parseObject(res).get("data")).get(0)).get("messageId");
                logger.info("等待3秒获取发送状态");
                Thread.sleep(3000);
                String res2 = HttpRequest.sendGet(GET_RESULT_URL + messageId);
                logger.info((String) JSON.parseObject(res2).get("msg"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {
        pushMsg("haha");
    }
}
