package io.springframework.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.springframework.common.exception.ApiException;
import io.springframework.common.response.HttpCodeMsg;
import io.springframework.common.response.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Wilson
 * @since 2020/3/5
 **/
@Slf4j
@ControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class GlobalExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ApiException.class)
    public ServerResponse<?> businessExceptionHandler(ApiException e) {
        log.error("业务错误： {}", e.getMessage());
        return ServerResponse.of(e.getCode(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = JsonProcessingException.class)
    public ServerResponse<?> jsonProcessingException(JsonProcessingException e) {
        log.error("json参数转换错误: {}", e.getMessage(), e);
        return ServerResponse.of(HttpCodeMsg.BAD_REQUEST, "参数转换错误");
    }
}

