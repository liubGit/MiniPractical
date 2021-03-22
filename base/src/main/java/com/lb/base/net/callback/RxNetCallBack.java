package com.lb.base.net.callback;

import android.text.TextUtils;

import com.lb.base.mvp.view.BaseView;
import com.lb.base.net.config.BaseResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Create by liub on 2021/3/12
 * Describe:
 */
public abstract class RxNetCallBack<T> implements Observer<BaseResult<T>> {
    private BaseView mView;

    public RxNetCallBack(BaseView view) {
        this.mView = view;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (mView != null) {
            mView.showLoadView();
        }
    }

    @Override
    public void onNext(BaseResult<T> tBaseResult) {
        if (tBaseResult.isSuccess()) {
            onSuccess(tBaseResult.getResult());
        } else {
            onFailure(tBaseResult.getError_code(), "服务器内部错误");
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mView != null) {
            mView.hideLoadView();
        }
        ResponseThrowable rt=ExceptionHandler.handleException(e);
        onFailure(rt.getCode(),rt.getMessage());
    }

    @Override
    public void onComplete() {
        if (mView != null) {
            mView.hideLoadView();
        }
    }

    public abstract void onSuccess(T data);

    public void onFailure(int code, String message) {
        if (!TextUtils.isEmpty(message)) {
            mView.showToast(message);
        }
//        //判断状态码 进行拦截
//        if (code == -1) {
//            //全局拦截：SESSION过期
//            NetDealUtil.getInstance().dealNetStatus(code, message);
//        }

    }
}
