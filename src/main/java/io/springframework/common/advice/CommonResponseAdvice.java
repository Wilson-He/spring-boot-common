package io.springframework.common.advice;

import io.springframework.common.autoconfigure.CommonBootProperties;
import io.springframework.common.response.ServerResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Wilson
 */
@AllArgsConstructor
@RestControllerAdvice
@ConditionalOnProperty(value = "spring.web-common.global-response.enable", havingValue = "true", matchIfMissing = true)
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final List<String> IGNORE_PATHS = Arrays.asList(
            "/swagger-resources/configuration/ui",
            "/swagger-resources/configuration/security",
            "/swagger-resources",
            "/v3/api-docs");

    private final CommonBootProperties commonBootProperties;

    @PostConstruct
    public void init() {
        Optional.ofNullable(commonBootProperties)
                .map(CommonBootProperties::getGlobalResponse)
                .map(CommonBootProperties.GlobalResponse::getIgnorePaths)
                .ifPresent(IGNORE_PATHS::addAll);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body instanceof ServerResponse || IGNORE_PATHS.contains(request.getURI().getPath())
                ? body : ServerResponse.success(body);
    }
}
