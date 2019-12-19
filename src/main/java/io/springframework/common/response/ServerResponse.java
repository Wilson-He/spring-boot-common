package io.springframework.common.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Wilson
 * @date 2019/9/20
 **/
@Getter
@ToString
public class ServerResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public static ServerResponse success() {
        return DefaultServerResponse.SUCCESS;
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

    public static <T> ServerResponse<T> serverError(String msg) {
        return new ServerResponse<>(DefaultCodeMsg.SERVER_ERROR.code(), msg);
    }


    public static <T> ServerResponse<T> paramError(String msg) {
        return new ServerResponse<>(DefaultCodeMsg.PARAM_FAILED.code(), msg);
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

    public String toJsonString() {
        return "{\"msg\":\"" + msg + "\"," + "\"code\":" + code + "}";
    }

    public ServerResponse<T> data(T data) {
        this.data = data;
        return this;
    }
}
