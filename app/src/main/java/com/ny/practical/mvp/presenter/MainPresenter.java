package com.ny.practical.mvp.presenter;

import android.content.Context;
import android.os.Handler;

import com.lb.base.mvp.presenter.BasePresenter;
import com.lb.base.net.callback.RxNetCallBack;
import com.lb.base.utils.log.Lmsg;
import com.ny.practical.bean.NewsInfo;
import com.ny.practical.mvp.contract.MainContract;
import com.ny.practical.mvp.model.MainModel;

/**
 * Create by liub on 2021/3/3
 * Describe:
 * 关联model与view关系
 */
public class MainPresenter extends BasePresenter<MainModel, MainContract.View> implements MainContract.Presenter {

    public MainPresenter(Context mContext) {
        super(mContext);
    }

    @Override
    public MainModel initModel() {
        return new MainModel(mContext);
    }

    @Override
    public void getDatas(String city) {
        mModel.getData(city).subscribe(new RxNetCallBack<NewsInfo>(mView) {
            @Override
            public void onSuccess(NewsInfo data) {
                mView.showData(data);
            }
        });
    }
}
