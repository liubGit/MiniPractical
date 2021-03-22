package com.lb.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lb.base.R;

/**
 * Create by liub on 2021/3/1
 * Describe:
 * 无数据
 */
public class NoDataView extends RelativeLayout {
    private final RelativeLayout mRlNoDataRoot;
    private final ImageView mImgNoDataView;


    public NoDataView(Context context,AttributeSet attrs) {
        super(context,attrs);
        inflate(context,R.layout.view_no_data,this);
        mRlNoDataRoot = findViewById(R.id.rl_no_data_root);
        mImgNoDataView = findViewById(R.id.img_no_data);
    }
    public void setNoDataBackground(int  colorResId){
        mRlNoDataRoot.setBackgroundColor(getResources().getColor(colorResId));
    }

    public void setNoDataView(int imgResId){
        mImgNoDataView.setImageResource(imgResId);
    }

}