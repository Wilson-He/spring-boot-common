package io.springframework.common.response;

/**
 * @author Wilson
 * @since 2019/12/19
 **/
public interface DefaultCodeMsg {
    ResponseCodeMsg SUCCESS = new ResponseCodeMsg(200, "success");
    ResponseCodeMsg PARAM_FAILED = new ResponseCodeMsg(400, "参数错误");
    ResponseCodeMsg UN_AUTHENTICATION = new ResponseCodeMsg(401, "请先登录");
    ResponseCodeMsg ACCESS_DENY = new ResponseCodeMsg(403, "权限不足");
    ResponseCodeMsg NOT_FOUND = new ResponseCodeMsg(404, "页面不见咯");
    ResponseCodeMsg METHOD_NOT_ALLOWED = new ResponseCodeMsg(405, "请求方法错误");
    ResponseCodeMsg UN_AUTHORIZATION = new ResponseCodeMsg(406, "权限不足");
    ResponseCodeMsg REQUEST_TIMEOUT = new ResponseCodeMsg(408, "请求超时");
    ResponseCodeMsg SERVER_ERROR = new ResponseCodeMsg(500, "服务器内部错误");
    ResponseCodeMsg BAD_GATEWAY = new ResponseCodeMsg(502, "网关错误");
    ResponseCodeMsg GATEWAY_TIMEOUT = new ResponseCodeMsg(504, "网关超时");
}
