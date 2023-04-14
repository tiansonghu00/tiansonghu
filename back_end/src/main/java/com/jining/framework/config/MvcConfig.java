package com.jining.framework.config;

import com.jining.framework.aop.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 程宇航
 * @version 1.0
 * @date 2022-12-08 19:55
 * @description
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 添加jwt拦截器，并指定拦截路径
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/verify")
                .excludePathPatterns("/test/**");
    }

    /**
     * jwt拦截器
     * @return
     */
    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
}
