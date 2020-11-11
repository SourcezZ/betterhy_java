package com.betterhy.utils;

import com.betterhy.exception.BeanUtilsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Bean utilities (copied from halo-master).
 *
 * @author johnniang
 * @date 2020/4/2 19:52
 */
public class BeanUtils {
    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    private BeanUtils() {
    }

    /**
     * Transforms from the source object. (copy same properties only)
     *
     * @param source      source data
     * @param targetClass target class must not be null
     * @param <T>         target class type
     * @return instance with specified type copying from source data; or null if source data is null
     * @throws BeanUtilsException if newing target instance failed or copying failed
     */
    @Nullable
    public static <T> T transformFrom(@Nullable Object source, @NonNull Class<T> targetClass) {
        Assert.notNull(targetClass, "Target class must not be null");

        if (source == null) {
            return null;
        }

        // Init the instance
        try {
            // New instance for the target class
            T targetInstance = targetClass.newInstance();
            // Copy properties
            org.springframework.beans.BeanUtils.copyProperties(source, targetInstance, getNullPropertyNames(source));
            // Return the target instance
            return targetInstance;
        } catch (Exception e) {
            throw new BeanUtilsException("Failed to new " + targetClass.getName() + " instance or copy properties", e);
        }
    }

    /**
     * Transforms from source data collection in batch.
     *
     * @param sources     source data collection
     * @param targetClass target class must not be null
     * @param <T>         target class type
     * @return target collection transforming from source data collection.
     * @throws BeanUtilsException if newing target instance failed or copying failed
     */
    @NonNull
    public static <T> List<T> transformFromInBatch(Collection<?> sources, @NonNull Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        }

        // Transform in batch
        return sources.stream()
                .map(source -> transformFrom(source, targetClass))
                .collect(Collectors.toList());
    }

    /**
     * Update properties (non null).
     *
     * @param source source data must not be null
     * @param target target data must not be null
     * @throws BeanUtilsException if copying failed
     */
    public static void updateProperties(@NonNull Object source, @NonNull Object target) {
        Assert.notNull(source, "source object must not be null");
        Assert.notNull(target, "target object must not be null");

        // Set non null properties from source properties to target properties
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
        } catch (BeansException e) {
            throw new BeanUtilsException("Failed to copy properties", e);
        }
    }

    /**
     * Gets null names array of property.
     *
     * @param source object data must not be null
     * @return null name array of property
     */
    @NonNull
    private static String[] getNullPropertyNames(@NonNull Object source) {
        return getNullPropertyNameSet(source).toArray(new String[0]);
    }

    /**
     * Gets null names set of property.
     *
     * @param source object data must not be null
     * @return null name set of property
     */
    @NonNull
    private static Set<String> getNullPropertyNameSet(@NonNull Object source) {

        Assert.notNull(source, "source object must not be null");
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String propertyName = propertyDescriptor.getName();
            Object propertyValue = beanWrapper.getPropertyValue(propertyName);

            // if property value is equal to null, add it to empty name set
            if (propertyValue == null) {
                emptyNames.add(propertyName);
            }
        }

        return emptyNames;
    }

    public static Map<String, Object> bean2Map(Object beanObject) {
        BeanWrapperImpl bean = new BeanWrapperImpl(beanObject);
        PropertyDescriptor[] desc = bean.getPropertyDescriptors();
        Map<String, Object> dataMap = new HashMap<>(desc.length);
        try {
            for (int i = 0; i < desc.length; ++i) {
                String name = desc[i].getName();

                if ((!(bean.isWritableProperty(name)))
                        || (!(bean.isReadableProperty(name)))) {
                    continue;
                }
                Object object = bean.getPropertyValue(name);
                if (object == null) {
                    continue;
                }
                dataMap.put(name, object);
            }
        }  catch (Exception e) {
            logger.error(OaUtils.getStackTraceInfo(e));
        }
        return dataMap;
    }

    public static <T> T map2Bean(Map map, Class<T> clazz) {
        BeanWrapper bw = new BeanWrapperImpl(clazz);
        PropertyDescriptor[] props = bw.getPropertyDescriptors();
        for (PropertyDescriptor pd : props) {
            String name = pd.getName();

            if ((!(bw.isWritableProperty(name)))
                    || (!(bw.isReadableProperty(name)))) {
                continue;
            }
            Class class0 = pd.getPropertyType();
            if (Enum.class.isAssignableFrom(class0)) {
                Object value = map.get(name);

                if (value == null) {
                    continue;
                }
                if (value.getClass() == class0) {
                    bw.setPropertyValue(name, value);
                } else {
                    String enumValue = String.valueOf(value);
                    if (enumValue.length() <= 0) {
                        continue;
                    }
                    Enum v = Enum.valueOf(class0, String.valueOf(value));
                    bw.setPropertyValue(name, v);
                }

            } else {
                Object value = map.get(name);

                if (value == null) {
                    continue;
                }
                bw.setPropertyValue(name, value);
            }

        }

        return (T) bw.getWrappedInstance();
    }

    public static List<Map<String, Object>> listBean2ListMap(List list) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (Iterator it = list.iterator(); it.hasNext();) {
            Map tmp = bean2Map(it.next());
            result.add(tmp);
        }
        return result;
    }

    public static <T> List<T> listMap2ListBean(List list, Class<T> class0) {
        List result = new ArrayList();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Object t = map2Bean((Map) it.next(), class0);
            result.add(t);
        }
        return result;
    }

    public static void list2Bean(List<?> srcBeanObject, Object destBeanObject,
                                 String listPropName) {
        BeanWrapperImpl destBean = new BeanWrapperImpl(destBeanObject);
        destBean.setPropertyValue(listPropName, srcBeanObject);
    }

    public static <T> T bean2Bean(Object srcBeanObject, Class<T> class0) {
        Object t = null;
        try {
            t = class0.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(OaUtils.getStackTraceInfo(e));
        }
        if (srcBeanObject instanceof List) {
            list2Bean((List) srcBeanObject, t, "list");
        } else {
            bean2Bean(srcBeanObject, t);
        }
        return (T) t;
    }

    public static void bean2Bean(Object srcBeanObject, Object destBeanObject) {
        BeanWrapperImpl srcBean = new BeanWrapperImpl(srcBeanObject);
        BeanWrapperImpl destBean = new BeanWrapperImpl(destBeanObject);

        PropertyDescriptor[] destDesc = destBean.getPropertyDescriptors();
        for (int i = 0; i < destDesc.length; ++i) {
            String name = destDesc[i].getName();

            if ((!(destBean.isWritableProperty(name)))
                    || (!(srcBean.isReadableProperty(name)))) {
                continue;
            }
            Object srcValue = srcBean.getPropertyValue(name);
            if (srcValue != null) {
                destBean.setPropertyValue(name, srcValue);
            }

        }
    }
}
