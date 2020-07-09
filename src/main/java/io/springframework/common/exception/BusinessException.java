package io.springframework.common.exception;

import io.springframework.common.response.DefaultCodeMsg;
import io.springframework.common.response.ResponseCodeMsg;
import lombok.Getter;

/**
 * 全局应用异常
 *
 * @author Wilson
 * @since 2020/3/5
 **/
@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = DefaultCodeMsg.SERVER_ERROR.code();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseCodeMsg codeMsg) {
        super(codeMsg.msg());
        this.code = codeMsg.code();
    }
}
