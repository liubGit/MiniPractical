package com.lb.base.mvp.view;

import android.content.Context;

/**
 * Create by liub on 2021/3/1
 * Describe:
 */
public interface BaseView extends INetErrView, INoDataView,ILoadView{
    void initView();

    void initListener();

    void initData();

    void showToast(String msg);

    void finishActivity();

    Context getContext();
}
