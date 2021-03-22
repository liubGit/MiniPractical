package com.ny.practical.view.adapter;

import android.content.Context;
import android.widget.TextView;

import com.lb.base.adapter.BaseAdapter;
import com.lb.base.adapter.BaseRecViewHolder;
import com.ny.practical.R;
import com.ny.practical.bean.NewsInfo;

import java.util.List;

import butterknife.BindView;

/**
 * Create by liub on 2021/3/15
 * Describe:
 * 新闻列表
 */
public class NewsAdapter extends BaseAdapter<NewsInfo.NewsList> {


    public NewsAdapter(Context mContext, List<NewsInfo.NewsList> list) {
        super(mContext, list);
    }

    @Override
    protected int onBindLayout() {
        return R.layout.item_news;
    }

    @Override
    protected void onBindData(BaseRecViewHolder holder, NewsInfo.NewsList data, int position) {
        holder.getTextView(R.id.tv_title).setText(data.getTitle());
        holder.getTextView(R.id.tv_content).setText(data.getDate());
    }
}
