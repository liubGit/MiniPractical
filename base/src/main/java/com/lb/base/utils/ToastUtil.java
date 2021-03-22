package com.lb.base.utils;

import android.widget.Toast;

import com.lb.base.BaseApplication;


/**
 * Create by liub on 2021/3/1
 * Describe: 吐司工具类
 */
public class ToastUtil {

    public static void showToast(String message) {
        Toast.makeText(BaseApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(int resid) {
        Toast.makeText(BaseApplication.getInstance(), BaseApplication.getInstance().getString(resid), Toast.LENGTH_SHORT)
                .show();
    }
}