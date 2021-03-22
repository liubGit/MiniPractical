package com.lb.base.mvp.model;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public class BaseModel {
    private Context mContext;
    private LifecycleProvider lifecycleProvider;

    public BaseModel(Context mContext) {
        this.mContext = mContext;
    }

    public void injectLifecycle(LifecycleProvider lifecycle) {
        this.lifecycleProvider = lifecycle;
    }

    public LifecycleProvider getLifecycle() {
        return lifecycleProvider;
    }

    public Context getmContext() {
        return mContext;
    }

    public void destory() {
    }


}
