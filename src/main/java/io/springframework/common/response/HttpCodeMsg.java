package io.springframework.common.response;

import lombok.AllArgsConstructor;

/**
 * @author Wilson
 */
@AllArgsConstructor
public enum HttpCodeMsg implements CodeMsg {
    /**
     * Http status code-msg
     */
    SUCCESS(200, "success"),
    BAD_REQUEST(400, "参数错误"),
    UN_AUTHENTICATION(401, "请先登录"),
    ACCESS_DENY(403, "权限不足"),
    NOT_FOUND(404, "页面不见咯"),
    METHOD_NOT_ALLOWED(405, "请求方法错误"),
    UN_AUTHORIZATION(406, "权限不足"),
    REQUEST_TIMEOUT(408, "请求超时"),
    SERVER_ERROR(500, "服务器内部错误"),
    BAD_GATEWAY(502, "网关错误"),
    GATEWAY_TIMEOUT(504, "网关超时");;

    private final Integer code;
    private final String msg;

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}
