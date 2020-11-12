package com.betterhy.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 缓存工具类
 *
 * @author Source
 * @date 2020-07-28 11:41
 **/
public class CacheUtils {
    public static <T> List<T> objectConvertToList(Object obj, Class<T> clazz) {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

}
