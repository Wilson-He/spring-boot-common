package io.springframework.common.exception;

import io.springframework.common.i18n.I18NKey;
import io.springframework.common.response.CodeMsg;
import io.springframework.common.response.HttpCodeMsg;
import lombok.Getter;

/**
 * 全局异常
 *
 * @author Wilson
 * @since 2020/3/5
 **/
@Getter
public class ApiException extends RuntimeException {
    private final Integer code;

    public ApiException(String message) {
        super(message);
        this.code = HttpCodeMsg.SERVER_ERROR.code();
    }

    public ApiException(I18NKey key) {
        super(key.key());
        this.code = HttpCodeMsg.SERVER_ERROR.code();
    }

    public ApiException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @param code
     * @param key
     * @version 0.2.1
     */
    public ApiException(Integer code, I18NKey key) {
        super(key.key());
        this.code = code;
    }

    public ApiException(CodeMsg codeMsg) {
        super(codeMsg.msg());
        this.code = codeMsg.code();
    }
}
