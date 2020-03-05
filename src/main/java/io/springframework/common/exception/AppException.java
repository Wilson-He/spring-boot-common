package io.springframework.common.exception;

import lombok.Getter;

/**
 * 全局应用异常
 *
 * @author Wilson
 * @since 2020/3/5
 **/
@Getter
public class AppException extends RuntimeException {
    private final Integer code;

    public AppException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
