package com.betterhy.common.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 *
 * @author Source
 * @date 2020-07-02 17:21
 **/
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
//                .allowedOrigins("http://127.0.0.1:8090")
//                .allowedOrigins("http://127.0.0.1:8091")
//                .allowedOrigins("http://127.0.0.1:33638")
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "/home/oa/static/");
    }


}
