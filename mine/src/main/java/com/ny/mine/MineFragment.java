package com.ny.mine;

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
 */
@Route(path = ARouterConstance.MINE_FRAGMENT_RUL)
public class MineFragment extends BaseMvpFragment {

    @BindView(R2.id.tv_mine_title)
    TextView textView;

    public static MineFragment newInstance(String title){
        MineFragment fragment=new MineFragment();
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
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(Bundle bundle) {
        String title=getArguments().getString("title");
        textView.setText(title);
    }
    @Override
    public boolean enableToolbar() {
        return false;
    }
    @Override
    public void initData() {

    }
}
