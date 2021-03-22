package com.ny.practical.mvp.view;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.mvp.base.BaseMvpActivity;
import com.lb.base.utils.log.Lmsg;
import com.ny.practical.R;
import com.ny.practical.bean.NewsInfo;
import com.ny.practical.mvp.contract.MainContract;
import com.ny.practical.mvp.model.MainModel;
import com.ny.practical.mvp.presenter.MainPresenter;
import com.ny.practical.view.adapter.NewsAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Create by liub on 2021/3/3
 * Describe:
 */
@Route(path = ARouterConstance.MVP_ACTIVITY_RUL)
public class MvpMainActivity extends BaseMvpActivity<MainModel, MainContract.View, MainPresenter> implements MainContract.View {

    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    private NewsAdapter newsAdapter;

    @Override
    protected int onBindLayout() {
        return R.layout.activity_mvp_main;
    }

    @Override
    public void initView() {
        setActionBarTitle("MVP");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsAdapter=new NewsAdapter(mContext,null);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void initData() {
        mPresenter.getDatas("北京");
    }

    @Override
    protected MainPresenter injectPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showData(NewsInfo str) {
        Lmsg.e("刷新页面");
       newsAdapter.refresh(str.getData());
    }
}