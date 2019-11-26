package com.example.administrator.l_net.net;

/**
 * Created by Administrator on 2019/11/25.
 */

public class ServerException extends Exception {
    private int code;
    private String message;
    public ServerException(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
