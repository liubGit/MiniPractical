package com.lb.base.net.config;

import java.io.Serializable;

import javax.crypto.interfaces.PBEKey;

/**
 * Create by liub on 2021/3/12
 * Describe:
 */
public class BaseResult<T> implements Serializable {
    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    public boolean isSuccess(){
        return this.reason.equals("success!");
    }
}
