package com.ny.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.arouter.ARouterHelper;
import com.lb.base.mvp.base.BaseMvpFragment;
import com.lb.base.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Create by liub on 2021/3/18
 * Describe:
 */

@Route(path = ARouterConstance.HOME_FRAGMENT_RUL)
public class HomeFragment extends BaseMvpFragment {

    @BindView(R2.id.btn_mvp)
    Button btnMvp;
    @BindView(R2.id.btn_mvvm)
    Button btnMvvm;
    @BindView(R2.id.btn_shop)
    Button btnShop;

    public static HomeFragment newInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BasePresenter injectPresenter() {
        return null;
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(Bundle bundle) {
        String title = getArguments().getString("title");
        setActionBarTitle(title);

        btnMvp.setOnClickListener(view -> {
                    ARouterHelper.go(ARouterConstance.MVP_ACTIVITY_RUL);
                }
        );
        btnMvvm.setOnClickListener(view -> {
            showToast("计划种");
        });
        btnShop.setOnClickListener(view -> {
            ARouterHelper.go(ARouterConstance.SHOP_ACTIVITY_RUL);
        });
    }

    @Override
    public void initData() {

    }
}
