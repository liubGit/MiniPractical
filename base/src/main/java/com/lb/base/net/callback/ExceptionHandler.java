package com.lb.base.net.callback;

import android.net.ParseException;
import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

/**
 * Create by liub on 2021/3/12
 * Describe:
 */
public class ExceptionHandler {

    public static ResponseThrowable handleException(Throwable e) {
        ResponseThrowable ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ResponseThrowable(e, SYSTEM_ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case SYSTEM_ERROR.UNAUTHORIZED:
                    ex.setMessage("操作未授权");
                    ex.setCode( SYSTEM_ERROR.UNAUTHORIZED);
                    break;
                case SYSTEM_ERROR.FORBIDDEN:
                    ex.setMessage("请求被拒绝");
                    break;
                case SYSTEM_ERROR.NOT_FOUND:
                    ex.setMessage ("资源不存在");
                    break;
                case SYSTEM_ERROR.REQUEST_TIMEOUT:
                    ex.setMessage("服务器执行超时");
                    break;
                case SYSTEM_ERROR.INTERNAL_SERVER_ERROR:
                    ex.setMessage ("服务器内部错误");
                    break;
                case SYSTEM_ERROR.SERVICE_UNAVAILABLE:
                    ex.setMessage ("服务器不可用");
                    break;
                default:
                    ex.setMessage ("网络错误");
                    break;
            }
            return ex;
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException || e instanceof MalformedJsonException) {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.PARSE_ERROR);
            ex.setMessage ("解析错误");
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.NETWORK_ERROR);
            ex.setMessage ("连接失败");
            return ex;
        } else if (e instanceof javax.net.ssl.SSLException) {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.SSL_ERROR);
            ex.setMessage ("证书验证失败");
            return ex;
        } else if (e instanceof ConnectTimeoutException || e instanceof SocketTimeoutException) {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.TIMEOUT_ERROR);
            ex.setMessage ("连接超时");
            return ex;
        }  else if (e instanceof java.net.UnknownHostException) {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.TIMEOUT_ERROR);
            ex.setMessage ("主机地址未知");
            return ex;
        } else {
            ex = new ResponseThrowable(e, SYSTEM_ERROR.UNKNOWN);
            ex.setMessage ("未知错误");
            return ex;
        }

    }

    public class SYSTEM_ERROR {
        public static final int UNAUTHORIZED = 401;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int REQUEST_TIMEOUT = 408;
        public static final int INTERNAL_SERVER_ERROR = 500;
        public static final int SERVICE_UNAVAILABLE = 503;

        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         SSL_ERROR         * 网络错误
         */
        public static final int NETWORK_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = 1006;

    }
}
