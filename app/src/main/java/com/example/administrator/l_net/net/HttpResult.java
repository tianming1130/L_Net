package com.example.administrator.l_net.net;

/**
 * Created by Administrator on 2019/10/27 0027.
 */

public class HttpResult<T> {
    private int code;
    private String message;
    private T data;

    public HttpResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
