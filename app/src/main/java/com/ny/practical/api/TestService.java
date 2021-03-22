package com.ny.practical.api;

import com.lb.base.net.config.BaseResult;
import com.ny.practical.bean.NewsInfo;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Create by liub on 2021/3/11
 * Describe:
 */
public interface TestService {

    @POST("http://v.juhe.cn/toutiao/index")
    Observable<BaseResult<NewsInfo>> getNewDatas(@Query("key") String key, @Query("city") String city);
}
