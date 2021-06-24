package io.springframework.common.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.springframework.common.exception.ApiException;
import io.springframework.common.i18n.I18NMessage;
import io.springframework.common.response.HttpCodeMsg;
import io.springframework.common.response.ServerResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wilson
 * @since 2020/3/5
 **/
@Slf4j
@ResponseBody
@RestControllerAdvice
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@AllArgsConstructor
public class GlobalExceptionHandler {
    private final I18NMessage i18NMessage;
    private final HttpServletRequest request;
    private static final String I18N_HEADER = "Lang";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ApiException.class)
    public ServerResponse<?> businessExceptionHandler(ApiException e) {
        log.error("业务错误： {}", e.getMessage());
        return ServerResponse.of(e.getCode(), i18NMessage.message(e.getMessage(), request.getHeader(I18N_HEADER), e.getMsgFormats()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = JsonProcessingException.class)
    public ServerResponse<?> jsonProcessingException(JsonProcessingException e) {
        log.error("json参数转换错误: {}", e.getMessage(), e);
        return ServerResponse.of(HttpCodeMsg.BAD_REQUEST, "参数转换错误");
    }
}

