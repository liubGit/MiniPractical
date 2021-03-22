package com.lb.base.mvp.base;

import android.os.Bundle;

import com.lb.base.mvp.model.BaseModel;
import com.lb.base.mvp.presenter.BasePresenter;

import androidx.annotation.Nullable;

/**
 * Create by liub on 2021/3/4
 * Describe:
 */
public abstract class BaseMvpFragment<M extends BaseModel, V, P extends BasePresenter<M, V>> extends BaseFragment {
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = injectPresenter();
        if (mPresenter != null) {
            mPresenter.attach((V) this);
            mPresenter.injectLifecycle(mActivity);
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDestroy();

    }

    protected abstract P injectPresenter();
}
