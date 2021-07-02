package io.springframework.common.interceptor;

import io.springframework.common.autoconfigure.CommonBootProperties;
import io.springframework.common.response.HeaderCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * @author Wilson
 */
@Component
@Slf4j
@ConditionalOnBean(CommonBootProperties.class)
public class CommonHandlerInterceptor implements HandlerInterceptor {
    private static final String IGNORE_METHOD = "OPTIONS";
    @Resource
    private CommonBootProperties properties;

    @PostConstruct
    public void init() {
        log.info("CommonHandlerInterceptor init completed.");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getMethod().equals(IGNORE_METHOD)) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "language, Content-Type, x-requested-with, X-Custom-Header, Authorization, token");
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        properties.getGlobalResponse().getHeaders().forEach(response::setHeader);
        if (HeaderCache.hasRefreshTimeHeaders()) {
            Enumeration<String> refreshHeaders = HeaderCache.refreshHeaders().keys();
            while (refreshHeaders.hasMoreElements()) {
                String refreshHeader = refreshHeaders.nextElement();
                response.setHeader(refreshHeader, request.getHeader(refreshHeader));
            }
        }
        return true;
    }
}
