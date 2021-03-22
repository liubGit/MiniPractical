package com.lb.base.mvp.view;

/**
 * Create by liub on 2021/3/3
 * Describe:
 */
public interface ILoadView {
    //显示初始加载的View，初始进来加载数据需要显示的View
    void showLoadView(String msg);
    void showLoadView();
    //隐藏初始加载的View
    void hideLoadView();
}
