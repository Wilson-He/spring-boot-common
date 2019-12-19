package io.springframework.common.response;

/**
 * @author Wilson
 * @since 2019/12/18
 **/
public interface IResponseCodeMsg {
    int SUCCESS = 200;
    int PARAM_ERROR = 400;
    int UN_AUTHENTICATION = 401;
    int ACCESS_DENY = 403;
    int NOT_FOUND = 404;
    int METHOD_NOT_ALLOWED = 405;
    int UN_AUTHORIZATION = 406;
    int REQUEST_TIMEOUT = 408;
    int SERVER_ERROR = 500;
    int BAD_GATEWAY = 502;
    int GATEWAY_TIMEOUT = 504;

    String SUCCESS_MSG = "success";
}
