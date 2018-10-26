package com.upsky.springboot.config;

import com.upsky.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {//原来的WebMvcConfigurerAdapter已过时，使用WebMvcConfigurationSupport会导致jsp不能跳转
    @Override
    public void addInterceptors(InterceptorRegistry registry) {//会导致之前controller中跳转/pages/*.jsp页面出错，解决：implements WebMvcConfigurer
        String[] checkLoginPathPatterns = {"/**"};//需要拦截的路径
        String[] loginExcludePathPatterns = {"/hello/hello","/hello/who"};//不需要拦截的路径

        registry.addInterceptor(new LoginInterceptor()).addPathPatterns(checkLoginPathPatterns).excludePathPatterns(loginExcludePathPatterns);
    }

//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/pages/**").setViewName("pages");
//    }
//
//    @Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pages/*").addResourceLocations("/pages/");
//    }
}
