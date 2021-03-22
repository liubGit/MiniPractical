package com.ny.practical;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lb.base.arouter.ARouterConstance;
import com.lb.base.mvp.base.BaseActivity;
import com.ny.home.HomeFragment;
import com.ny.mine.MineFragment;
import com.ny.practical.mvp.view.MvpMainActivity;
import com.ny.shop.ShopFragment;
import com.ny.shop.ShopMainActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.navigation)
    BottomNavigationView navigationView;


    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private ShopFragment shopCartFragment;
    private MineFragment mineFragment;

    private Fragment mCurrFragment;

    @Override
    protected int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean enableToolbar() {
        return false;
    }

    @Override
    public void initView() {
        initFrameView();

    }

    private void initFrameView() {
        navigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            switch (id) {
                case R.id.navigation_home:
                    switchFragment(mCurrFragment, homeFragment, "home");
                    mCurrFragment = homeFragment;
                    return true;
                case R.id.navigation_shop:
                    switchFragment(mCurrFragment, shopFragment, "shop");
                    mCurrFragment = shopFragment;
                    return true;
                case R.id.navigation_shop_cart:
                    switchFragment(mCurrFragment, shopCartFragment, "shop_cart");
                    mCurrFragment = shopCartFragment;
                    return true;
                case R.id.navigation_my:
                    switchFragment(mCurrFragment, mineFragment, "mine");
                    mCurrFragment = mineFragment;
                    return true;
            }
            return false;
        });
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance("home");
        }
        if (shopFragment == null) {
            shopFragment = ShopFragment.newInstance("shop");
        }
        if (shopCartFragment == null) {
            shopCartFragment = ShopFragment.newInstance("shop_cart");
        }
        if (mineFragment == null) {
            mineFragment = MineFragment.newInstance("mine");
        }
        mCurrFragment = homeFragment;
        if (homeFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment, "home").commit();
        }

    }

    /**
     * 切换fragment
     *
     * @param mCurrFragment 当前碎片
     * @param showFragment  需要显示的碎片
     * @param tag
     */
    private void switchFragment(Fragment mCurrFragment, Fragment showFragment, String tag) {
        if (mCurrFragment == null || showFragment == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!showFragment.isAdded()) {
            transaction.hide(mCurrFragment).add(R.id.frame_layout, showFragment, tag);
        } else {
            transaction.hide(mCurrFragment).show(showFragment);
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void initData() {

    }

}