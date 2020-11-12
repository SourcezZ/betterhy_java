package com.betterhy.common.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 数据控制类
 *
 * @author Source
 * @date 2020-08-03 16:17
 **/

@Component
public class DataAccessManager implements ApplicationContextAware {
    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        DataAccessManager.appContext = context;
    }


    private static Object getQueryMapper(Class<?> modelTyp) {
        String name = modelTyp.getSimpleName();
        String mapperName = name + "Mapper";
        return appContext.getBean(mapperName.substring(0, 1).toLowerCase()
                + mapperName.substring(1));
    }

    public static <T> int countByExample(Object example, Class<T> modelTyp) {
        Object dao = getQueryMapper(modelTyp);
        try {
            return (Integer) dao.getClass().getMethod("countByExample",example.getClass())
                    .invoke(dao, example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> selectByExample(Object example, Class<T> modelTyp) {
        Object dao = getQueryMapper(modelTyp);
        try {
            return (List<T>) dao.getClass().getMethod("selectByExample",example.getClass())
                    .invoke(dao, example);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T selectByPrimaryKey(Object key, Class<T> modelTyp) {
        Object dao = getQueryMapper(modelTyp);
        try {
            return (T) dao.getClass().getMethod("selectByPrimaryKey",key.getClass())
                    .invoke(dao, key);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getMapper(Class<T> mapperType) {
        String name = mapperType.getSimpleName();
        return (T) appContext.getBean(name.substring(0, 1).toLowerCase() + name.substring(1));
    }
}

