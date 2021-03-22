package com.lb.base.net;

import com.lb.base.net.config.BaseResult;

import io.reactivex.Observable;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Create by liub on 2021/3/11
 * Describe: 提供一个公共api服务
 */
public interface CommonService {
    @POST("/userapi/user/login")
    Observable<BaseResult<String>> login(@Query("username") String name, @Query("password") String pwd);

    @POST("/oauth/token")
    Observable<BaseResult<String>> getToken(@Header(value = "Authorization") String authorization, @Query("grant_type") String type,
                               @Query("username") String username, @Query("password") String password);
}
