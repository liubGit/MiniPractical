package com.ny.shop;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.arouter.ARouterHelper;
import com.lb.base.mvp.base.BaseMvpActivity;
import com.lb.base.mvp.presenter.BasePresenter;

import butterknife.BindView;

@Route(path = ARouterConstance.SHOP_ACTIVITY_RUL)
public class ShopMainActivity extends BaseMvpActivity {

    @BindView(R2.id.tv_shop)
    TextView test;
    @Override
    protected int onBindLayout() {
        return R.layout.activity_shop_main;
    }

    @Override
    public void initView() {
        test.setOnClickListener(view->{
            ARouterHelper.go(ARouterConstance.MINE_ACTIVITY_RUL,"123");
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter injectPresenter() {
        return null;
    }
}