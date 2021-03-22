package com.lb.base.arouter;

import android.net.Uri;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Create by liub on 2021/3/16
 * Describe:
 * 路由跳转帮助类
 */
public class ARouterHelper {
    public static void go(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    public static void go(Uri uri) {
        ARouter.getInstance().build(uri).navigation();
    }

    public static void go(String path, String data) {
        ARouter.getInstance().build(path)
                .withString("data", data)
                .navigation();
    }
}
