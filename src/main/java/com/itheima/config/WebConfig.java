package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginChkInteceptor lci;
    @Autowired
    private LoginCheckInterceptor lci;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lci).addPathPatterns("/**");

    }
}
