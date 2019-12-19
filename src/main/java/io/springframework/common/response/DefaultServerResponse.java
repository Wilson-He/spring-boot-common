package io.springframework.common.response;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
public interface DefaultServerResponse {
    ServerResponse SUCCESS = ServerResponse.build(DefaultCodeMsg.SUCCESS);
    ServerResponse PARAM_FAILED = ServerResponse.build(DefaultCodeMsg.PARAM_FAILED);
    ServerResponse UN_AUTHENTICATION = ServerResponse.build(DefaultCodeMsg.UN_AUTHENTICATION);
    ServerResponse ACCESS_DENY = ServerResponse.build(DefaultCodeMsg.ACCESS_DENY);
    ServerResponse NOT_FOUND = ServerResponse.build(DefaultCodeMsg.NOT_FOUND);
    ServerResponse METHOD_NOT_ALLOWED = ServerResponse.build(DefaultCodeMsg.METHOD_NOT_ALLOWED);
    ServerResponse UN_AUTHORIZATION = ServerResponse.build(DefaultCodeMsg.UN_AUTHORIZATION);
    ServerResponse REQUEST_TIMEOUT = ServerResponse.build(DefaultCodeMsg.REQUEST_TIMEOUT);
    ServerResponse SERVER_ERROR = ServerResponse.build(DefaultCodeMsg.SERVER_ERROR);
    ServerResponse BAD_GATEWAY = ServerResponse.build(DefaultCodeMsg.BAD_GATEWAY);

    ServerResponse GATEWAY_TIMEOUT = ServerResponse.build(DefaultCodeMsg.GATEWAY_TIMEOUT);
}
