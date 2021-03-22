package com.lb.base.net;

import android.content.Context;

import com.lb.base.net.config.BaseUrl;
import com.lb.base.net.config.HttpConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Create by liub on 2021/3/9
 * Describe:
 */
public class RetrofitManager {
    private static RetrofitManager mInstance;
    private Context mContext;
    private Retrofit mRetrofit;

    public void init(Context context) {
        this.mContext = context;
    }

    public static RetrofitManager getInstance() {
        if (null == mInstance) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .client(HttpConfig.getOkHttpClient())
                .baseUrl(BaseUrl.BASE_URL_T)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 提供公共的服务
     *
     * @return
     */
    public CommonService getCommonService() {
        return mRetrofit.create(CommonService.class);
    }

    public <T> T getServer(Class<T> service) {
        return mRetrofit.create(service);
    }
}
