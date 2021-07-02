package io.springframework.common.config;

import io.springframework.common.interceptor.CommonHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Wilson
 */
@Configuration
public class CommonWebConfig implements WebMvcConfigurer {
    @Resource
    private CommonHandlerInterceptor commonHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonHandlerInterceptor);
    }
}
