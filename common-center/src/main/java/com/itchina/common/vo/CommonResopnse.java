package com.itchina.common.vo;

import java.io.Serializable;

/**
 * @Date: 2021/4/7 22:18
 * @Desc:
 */
public class CommonResopnse<T> implements Serializable {
    private int code;
    private String message;
    private T data;
    public CommonResopnse(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static CommonResopnse ofMessage(int code, String message) {
        return new CommonResopnse(code, message);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResopnse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
