package io.springframework.common.response;

import lombok.ToString;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@ToString
public class ServerResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    private static final ServerResponse SUCCESS = ServerResponse.build(DefaultCodeMsg.SUCCESS);
    private static final ServerResponse PARAM_FAILED = ServerResponse.build(DefaultCodeMsg.PARAM_FAILED);
    private static final ServerResponse UN_AUTHENTICATION = ServerResponse.build(DefaultCodeMsg.UN_AUTHENTICATION);
    private static final ServerResponse ACCESS_DENY = ServerResponse.build(DefaultCodeMsg.ACCESS_DENY);
    private static final ServerResponse NOT_FOUND = ServerResponse.build(DefaultCodeMsg.NOT_FOUND);
    private static final ServerResponse METHOD_NOT_ALLOWED = ServerResponse.build(DefaultCodeMsg.METHOD_NOT_ALLOWED);
    private static final ServerResponse UN_AUTHORIZATION = ServerResponse.build(DefaultCodeMsg.UN_AUTHORIZATION);
    private static final ServerResponse REQUEST_TIMEOUT = ServerResponse.build(DefaultCodeMsg.REQUEST_TIMEOUT);
    private static final ServerResponse SERVER_ERROR = ServerResponse.build(DefaultCodeMsg.SERVER_ERROR);
    private static final ServerResponse BAD_GATEWAY = ServerResponse.build(DefaultCodeMsg.BAD_GATEWAY);
    private static final ServerResponse GATEWAY_TIMEOUT = ServerResponse.build(DefaultCodeMsg.GATEWAY_TIMEOUT);

    public static ServerResponse success() {
        return SUCCESS;
    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(data);
    }

    public static <T> ServerResponse<T> build(ResponseCodeMsg codeMsg) {
        return new ServerResponse<>(codeMsg.code(), codeMsg.msg());
    }

    public static <T> ServerResponse<T> build(Integer code, String msg) {
        return new ServerResponse<>(code, msg);
    }

    /**
     * 服务器内部错误
     *
     * @return
     */
    public static ServerResponse serverError() {
        return SERVER_ERROR;
    }

    /**
     * 服务器内部错误
     *
     * @param msg 错误信息
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> serverError(String msg) {
        return new ServerResponse<>(SERVER_ERROR.code, msg);
    }

    /**
     * 参数错误
     *
     * @return
     */
    public static ServerResponse paramError() {
        return PARAM_FAILED;
    }

    /**
     * 参数错误
     *
     * @param msg 错误信息
     * @return
     */
    public static <T> ServerResponse<T> paramError(String msg) {
        return new ServerResponse<>(PARAM_FAILED.code, msg);
    }

    private ServerResponse(ResponseCodeMsg codeMsg) {
        this.code = codeMsg.code();
        this.msg = codeMsg.msg();
    }

    private ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(T data) {
        this.code = DefaultCodeMsg.SUCCESS.code();
        this.msg = DefaultCodeMsg.SUCCESS.msg();
        this.data = data;
    }

    public ServerResponse<T> data(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static ServerResponse paramFailed() {
        return PARAM_FAILED;
    }

    public static ServerResponse unAuthentication() {
        return UN_AUTHENTICATION;
    }

    public static ServerResponse accessDeny() {
        return ACCESS_DENY;
    }

    public static ServerResponse notFound() {
        return NOT_FOUND;
    }

    public static ServerResponse methodNotAllowed() {
        return METHOD_NOT_ALLOWED;
    }

    public static ServerResponse unAuthorization() {
        return UN_AUTHORIZATION;
    }

    public static ServerResponse requestTimeout() {
        return REQUEST_TIMEOUT;
    }

    public static ServerResponse badGateway() {
        return BAD_GATEWAY;
    }

    public static ServerResponse gatewayTimeout() {
        return GATEWAY_TIMEOUT;
    }
}
