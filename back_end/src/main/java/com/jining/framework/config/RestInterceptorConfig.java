package com.jining.framework.config;

import com.jining.framework.aop.RestProtectInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName RestInterceptorConfig
 * @Date 2022/10/29 10:05 PM
 * @Author Goslly
 * @Description
 **/
@Slf4j
@Configuration
public class RestInterceptorConfig implements WebMvcConfigurer {

    /**
     * 是否启用
     */
    @Value("${tracking.framework.rest.protect.enabled:true}")
    private boolean restProtectEnabled;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if (restProtectEnabled) {
            log.info("Add RestProtectInterceptor...");
            registry.addInterceptor(new RestProtectInterceptor())
                    .addPathPatterns("/**");
        }
    }

}
