package io.springframework.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.springframework.common.exception.BusinessException;
import io.springframework.common.response.ResponseConstant;
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
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ServerResponse businessExceptionHandler(BusinessException e) {
        log.error("业务错误： {}", e.getMessage());
        return ServerResponse.build(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = JsonProcessingException.class)
    @ResponseBody
    public ServerResponse jsonProcessingException(JsonProcessingException e) {
        log.error(e.getMessage(), e);
        return ServerResponse.build(ResponseConstant.BAD_REQUEST, "json转换错误");
    }
}

