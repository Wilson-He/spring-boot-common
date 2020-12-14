package io.springframework.common.response;

/**
 * @author Wilson
 * @since 2019/12/19
 **/
public class ResponseCodeMsg {
    private final int code;
    private final String msg;

    public ResponseCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
