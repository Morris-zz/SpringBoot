package com.example.oppo.demo;

import com.example.oppo.demo.Interceptor.JobInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaozheng
 * @create 2019/2/11
 **/
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new JobInterceptor()).addPathPatterns("/**");
    }
}
