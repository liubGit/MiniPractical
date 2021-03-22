package com.lb.base.mvp.presenter;

import android.content.Context;

import com.lb.base.mvp.model.BaseModel;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public abstract class BasePresenter<M extends BaseModel, V> {
    protected Context mContext;
    protected V mView;
    protected M mModel;

    public BasePresenter(Context mContext) {
        this.mContext = mContext;

    }

    public void attach(V view) {
        attachView(view);
        attachModel();
    }

    private void attachModel() {
        mModel = initModel();
    }

    public abstract M initModel();


    private void attachView(V view) {
        this.mView = view;
    }

    public void detach() {
        detachView();
        detachModel();
    }

    private void detachModel() {
        mModel.destory();
        mModel = null;
    }

    private void detachView() {
        mView = null;
    }

    public void injectLifecycle(LifecycleProvider lifecycleProvider) {
        if (mModel != null) {
            mModel.injectLifecycle(lifecycleProvider);
        }
    }
}
