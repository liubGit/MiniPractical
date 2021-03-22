package com.lb.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.lb.base.R;

/**
 * Create by liub on 2021/3/1
 * Describe:
 * 网络错误页面
 */
public class NetErrorView extends RelativeLayout {
    private OnClickListener mOnClickListener;
    private final RelativeLayout mRlNetWorkError;

    public NetErrorView(Context context, AttributeSet attrs) {
        super(context,attrs);
        inflate(context, R.layout.view_net_error, this);
//        findViewById(R.id.btn_net_refresh).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (mOnClickListener != null) {
//                    mOnClickListener.onClick(v);
//                }
//            }
//        });
        mRlNetWorkError = findViewById(R.id.rl_net_error);
    }

    public void setRefreshBtnClickListener(OnClickListener listener) {
        mOnClickListener = listener;
    }

    public void setNetErrorBackground(int colorResId) {
        mRlNetWorkError.setBackgroundColor(getResources().getColor(colorResId));
    }
}
