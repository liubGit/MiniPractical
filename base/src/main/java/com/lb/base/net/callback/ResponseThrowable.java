package com.lb.base.net.callback;

import androidx.annotation.Nullable;

/**
 * Create by liub on 2021/3/12
 * Describe:
 *
 */
public class ResponseThrowable extends Exception {
    private int code;
    private String message;

    public ResponseThrowable(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
