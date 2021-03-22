package com.lb.base.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public class BaseRecViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewHolder;
    private View view;

    public BaseRecViewHolder(View view) {
        super(view);
        this.view = view;
        viewHolder = new SparseArray<>();
    }

    public <T extends View> T get(int id) {
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }

    public View getConvertView() {
        return view;
    }

    public View getView(int id) {
        return get(id);
    }

    public TextView getTextView(int id) {

        return get(id);
    }

    public Button getButton(int id) {

        return get(id);
    }

    public ImageView getImageView(int id) {
        return get(id);
    }

    public void setTextView(int id, CharSequence charSequence) {
        getTextView(id).setText(charSequence);
    }
}
