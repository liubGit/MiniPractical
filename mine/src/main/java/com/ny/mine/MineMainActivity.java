package com.ny.mine;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.mvp.base.BaseMvpActivity;
import com.lb.base.mvp.presenter.BasePresenter;

import butterknife.BindView;

@Route(path = ARouterConstance.MINE_ACTIVITY_RUL)
public class MineMainActivity extends BaseMvpActivity {

    @BindView(R2.id.tv_mine)
    TextView test;

    @Autowired(name = "data")
   public String string;
    @Override
    protected int onBindLayout() {
        return R.layout.activity_mine_main;
    }

    @Override
    public void initView() {
        test.setText(string);
    }

    @Override
    public void initData() {

    }

    @Override
    protected BasePresenter injectPresenter() {
        return null;
    }
}