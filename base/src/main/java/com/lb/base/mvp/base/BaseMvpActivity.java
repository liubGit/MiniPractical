package com.lb.base.mvp.base;

import android.os.Bundle;

import com.lb.base.mvp.model.BaseModel;
import com.lb.base.mvp.presenter.BasePresenter;


/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public abstract class BaseMvpActivity<M extends BaseModel, V, P extends BasePresenter<M, V>> extends BaseActivity {


    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = injectPresenter();
        if (mPresenter != null) {
            mPresenter.attach((V) this);
            mPresenter.injectLifecycle(this);
        }
        super.onCreate(savedInstanceState);
    }

    protected abstract P injectPresenter();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detach();
        }
        super.onDestroy();

    }
}
