package com.lb.base.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lb.base.R;


/**
 * Create by liub on 2021/3/4
 * Describe: 
 * 为完善的自定义加载菊花动画
 */
@Deprecated
public class LoadingInitView extends RelativeLayout {
    private final AnimationDrawable mAnimationDrawable;
    public LoadingInitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.view_init_loading,this);
        ImageView imgLoading = findViewById(R.id.ivProgress);
        mAnimationDrawable = (AnimationDrawable) imgLoading.getDrawable();
    }
    public void startLoading(){
        mAnimationDrawable.start();
    }
    public void stopLoading(){
        mAnimationDrawable.stop();
    }
    public void loading(boolean b){
        if(b){
            startLoading();
        }else{
            stopLoading();
        }
    }


}
