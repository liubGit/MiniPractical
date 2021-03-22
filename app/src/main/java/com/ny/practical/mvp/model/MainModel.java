package com.ny.practical.mvp.model;

import android.content.Context;

import com.lb.base.mvp.model.BaseModel;
import com.lb.base.net.RetrofitManager;
import com.lb.base.net.config.BaseResult;
import com.lb.base.net.config.RxAdapter;
import com.ny.practical.api.TestService;
import com.ny.practical.bean.NewsInfo;
import com.ny.practical.mvp.contract.MainContract;

import io.reactivex.Observable;

/**
 * Create by liub on 2021/3/3
 * Describe:
 * 获取数据model
 */
public class MainModel extends BaseModel implements MainContract.Model {

    public MainModel(Context mContext) {
        super(mContext);
    }

    @Override
    public Observable<BaseResult<NewsInfo>> getData(String city) {
        return RetrofitManager.getInstance()
                .getServer(TestService.class)
                .getNewDatas("b91ad917ea954671fcebcef8ab657500",city)
                .compose(RxAdapter.bindUnitEvent(getLifecycle()))
                .compose(RxAdapter.schedulersTransformer());
    }

}
