package io.springframework.common.response;

/**
 * @author Wilson
 * @since 2019/12/18
 **/
public interface ResponseConstant {
    int SUCCESS = 200;
    /**
     * 参数错误
     */
    int BAD_REQUEST = 400;
    /**
     * 未登录
     */
    int UN_AUTHENTICATION = 401;
    /**
     * 权限不足
     */
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;
    /**
     * 请求方法错误(POST、GET、PUT、DELETE)
     */
    int METHOD_NOT_ALLOWED = 405;
    /**
     * 无法使用请求的内容特性响应请求的网页
     */
    int NOT_ACCEPTABLE = 406;
    /**
     * 请求超时
     */
    int REQUEST_TIMEOUT = 408;
    /**
     * 不支持的Content-Type {@link org.springframework.http.MediaType}
     */
    int UNSUPPORTED_MEDIA_TYPE = 415;
    /**
     * 服务器内部错误
     */
    int SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    /**
     * gateway超时
     */
    int GATEWAY_TIMEOUT = 504;

    String SUCCESS_MSG = "success";
}
