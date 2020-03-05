package io.springframework.common.handler;

import io.springframework.common.exception.AppException;
import io.springframework.common.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wilson
 * @since 2020/3/5
 **/
@Slf4j
@ControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AppException.class)
    @ResponseBody
    public ServerResponse appExceptionHandler(AppException e) {
        log.error("业务错误： {}", e.getMessage());
        return ServerResponse.build(e.getCode(), e.getMessage());
    }
}

