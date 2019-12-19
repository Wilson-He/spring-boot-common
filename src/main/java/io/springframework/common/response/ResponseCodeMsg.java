package io.springframework.common.response;

/**
 * @author Wilson
 * @since 2019/12/19
 **/
public class ResponseCodeMsg {
    private int code;
    private String msg;

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
