package com.lb.base.net.config;

import com.lb.base.manage.ActivityManager;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by liub on 2021/3/15
 * Describe:
 * 线程调度器
 */
public class RxAdapter {

    /**
     * 生命周期绑定
     * @param lifecycle
     * @return
     */
    public static LifecycleTransformer bindUnitEvent(LifecycleProvider lifecycle) {
        if (lifecycle != null) {
            return lifecycle.bindUntilEvent(ActivityEvent.DESTROY);
        } else {
            throw new IllegalArgumentException("context not the LifecycleProvider type");
        }
    }

    /**
     * 线程调度器
     */
    public static ObservableTransformer schedulersTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

//    public static ObservableTransformer exceptionTransformer() {
//
//        return new ObservableTransformer() {
//            @Override
//            public ObservableSource apply(Observable observable) {
//                return observable
//                        .map(new HandleFuc())  //这里可以取出BaseResponse中的Result
//                        .onErrorResumeNext(new HttpResponseFunc());
//            }
//        };
//    }
}
