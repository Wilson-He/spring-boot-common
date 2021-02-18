package io.springframework.common.response;

import lombok.Data;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@Data
public class ServerResponse<T> {
	private Integer code;
	private String msg;
	private T data;

	public static <T> ServerResponse<T> of(CodeMsg codeMsg) {
		return new ServerResponse<>(codeMsg.code(), codeMsg.msg());
	}

	public static <T> ServerResponse<T> of(CodeMsg codeMsg, String msg) {
		return new ServerResponse<>(codeMsg.code(), msg);
	}

	public static <T> ServerResponse<T> of(Integer code, String msg) {
		return new ServerResponse<>(code, msg);
	}


	public static <T> ServerResponse<T> success(T data) {
		return new ServerResponse<>(data);
	}

	/**
	 * 参数错误
	 *
	 * @param msg 错误信息
	 * @return
	 */
	public static <T> ServerResponse<T> paramError(String msg) {
		return of(HttpCodeMsg.BAD_REQUEST, msg);
	}

	/**
	 * 服务器内部错误
	 *
	 * @param msg 错误信息
	 * @param <T>
	 * @return
	 */
	public static <T> ServerResponse<T> serverError(String msg) {
		return new ServerResponse<>(HttpCodeMsg.SERVER_ERROR.code(), msg);
	}


	public ServerResponse<T> data(T data) {
		this.data = data;
		return this;
	}

	private ServerResponse(CodeMsg codeMsg) {
		this.code = codeMsg.code();
		this.msg = codeMsg.msg();
	}

	private ServerResponse(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private ServerResponse(T data) {
		this.code = HttpCodeMsg.SUCCESS.code();
		this.msg = HttpCodeMsg.SUCCESS.msg();
		this.data = data;
	}

	public static ServerResponse<?> SUCCESS() {
		return SUCCESS;
	}

	public static ServerResponse<?> paramFailed() {
		return PARAM_FAILED;
	}

	public static ServerResponse<?> unAuthentication() {
		return UN_AUTHENTICATION;
	}

	public static ServerResponse<?> accessDeny() {
		return ACCESS_DENY;
	}

	public static ServerResponse<?> notFound() {
		return NOT_FOUND;
	}

	public static ServerResponse<?> methodNotAllowed() {
		return METHOD_NOT_ALLOWED;
	}

	public static ServerResponse<?> unAuthorization() {
		return UN_AUTHORIZATION;
	}

	public static ServerResponse<?> requestTimeout() {
		return REQUEST_TIMEOUT;
	}

	public static ServerResponse<?> serverError() {
		return SERVER_ERROR;
	}

	public static ServerResponse<?> badGateway() {
		return BAD_GATEWAY;
	}

	public static ServerResponse<?> gatewayTimeout() {
		return GATEWAY_TIMEOUT;
	}



	private static final ServerResponse<?> SUCCESS = ServerResponse.of(HttpCodeMsg.SUCCESS);
	private static final ServerResponse<?> PARAM_FAILED = ServerResponse.of(HttpCodeMsg.BAD_REQUEST);
	private static final ServerResponse<?> UN_AUTHENTICATION = ServerResponse.of(HttpCodeMsg.UN_AUTHENTICATION);
	private static final ServerResponse<?> ACCESS_DENY = ServerResponse.of(HttpCodeMsg.ACCESS_DENY);
	private static final ServerResponse<?> NOT_FOUND = ServerResponse.of(HttpCodeMsg.NOT_FOUND);
	private static final ServerResponse<?> METHOD_NOT_ALLOWED = ServerResponse.of(HttpCodeMsg.METHOD_NOT_ALLOWED);
	private static final ServerResponse<?> UN_AUTHORIZATION = ServerResponse.of(HttpCodeMsg.UN_AUTHORIZATION);
	private static final ServerResponse<?> REQUEST_TIMEOUT = ServerResponse.of(HttpCodeMsg.REQUEST_TIMEOUT);
	private static final ServerResponse<?> SERVER_ERROR = ServerResponse.of(HttpCodeMsg.SERVER_ERROR);
	private static final ServerResponse<?> BAD_GATEWAY = ServerResponse.of(HttpCodeMsg.BAD_GATEWAY);
	private static final ServerResponse<?> GATEWAY_TIMEOUT = ServerResponse.of(HttpCodeMsg.GATEWAY_TIMEOUT);
}
