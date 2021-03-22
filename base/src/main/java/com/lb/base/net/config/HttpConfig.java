package com.lb.base.net.config;

import com.lb.base.utils.DateUtil;
import com.lb.base.utils.log.Lmsg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Create by liub on 2021/3/11
 * Describe:
 */
public class HttpConfig {

    private static String TAG = HttpConfig.class.getSimpleName();
    private static String appId, versionCode, versionName;

    public static OkHttpClient getOkHttpClient() {
        long TIME_OUT = 20 * 1000;
        return new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
//                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }

    /**
     * 初始化请求头参数
     * @param appId
     * @param versionCode
     * @param versionName
     */
    public static void initRequestHeader(String appId, String versionCode, String versionName) {
        HttpConfig.appId=appId;
        HttpConfig.versionCode=versionCode;
        HttpConfig.versionName=versionName;
    }

    /**
     * 添加请求头
     */
    private static class HeaderInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.header("appid", appId);
            builder.header("versioncode", versionCode);
            builder.header("versionname", versionName);
            return chain.proceed(request);
        }
    }

    /**
     * 请求日志打印
     */
    private static class LogInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.currentTimeMillis();
            Response response = chain.proceed(chain.request());
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Lmsg.i(TAG, "----------Request Start----------------");
            Lmsg.i(TAG, "| " + request.toString() + request.headers().toString());
            Lmsg.i(TAG, "| Response:" + content);
            Lmsg.i(TAG, "----------Request End:" + duration + "毫秒----------");
            return response.newBuilder()
                    .body(ResponseBody.create(mediaType, content))
                    .build();
        }
    }


}
