package com.ny.practical.mvp.contract;

import com.lb.base.mvp.view.BaseView;
import com.lb.base.net.config.BaseResult;
import com.ny.practical.bean.NewsInfo;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Create by liub on 2021/3/3
 * Describe:
 */
public interface MainContract {
    interface Presenter {
        void getDatas(String city);
    }

    interface View extends BaseView {
        void showData(NewsInfo str);
    }

    interface Model {
        Observable<BaseResult<NewsInfo>> getData(String city);
    }
}
