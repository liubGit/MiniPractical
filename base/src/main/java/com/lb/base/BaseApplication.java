package com.lb.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.multidex.MultiDex;

/**
 * Create by liub on 2021/3/1
 * Describe:
 */
public class BaseApplication extends Application {
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        MultiDex.install(this);
    }

    public static BaseApplication getInstance() {
        return mApplication;
    }
}
