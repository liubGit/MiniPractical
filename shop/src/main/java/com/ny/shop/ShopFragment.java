package com.ny.shop;


import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.mvp.base.BaseMvpFragment;
import com.lb.base.mvp.presenter.BasePresenter;

import butterknife.BindView;

/**
 * Create by liub on 2021/3/17
 * Describe:
 * 商城
 */

@Route(path = ARouterConstance.SHOP_FRAGMENT_RUL)
public class ShopFragment extends BaseMvpFragment {

    @BindView(R2.id.tv_shop_title)
    TextView textView;

    public static ShopFragment newInstance(String title){
        ShopFragment fragment=new ShopFragment();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BasePresenter injectPresenter() {
        return null;
    }


    @Override
    public int onBindLayout() {
        return  R.layout.fragment_shop;
    }

    @Override
    public void initView(Bundle bundle) {
        String title=getArguments().getString("title");
        textView.setText(title);
        setActionBarTitle(title);
    }



    @Override
    public void initData() {

    }

}
