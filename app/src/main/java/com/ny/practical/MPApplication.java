package com.ny.practical;

import com.lb.base.BaseApplication;
import com.lb.base.net.RetrofitManager;
import com.lb.base.net.config.HttpConfig;

/**
 * Create by liub on 2021/1/29
 * Describe:
 */
public class MPApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpConfig.initRequestHeader("1001", String.valueOf(BuildConfig.VERSION_CODE), BuildConfig.VERSION_NAME);
    }
}
