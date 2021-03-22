package com.lb.base.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by liub on 2021/3/2
 * Describe:
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseRecViewHolder> {
    protected List<T> list;
    protected Context mContext;
    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickListener<T> onItemLongClickListener;

    public BaseAdapter(Context mContext, List<T> list) {
        this.mContext = mContext;
        this.list = list;
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
    }

    @NonNull
    @Override
    public BaseRecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int mItemLayoutRes = onBindLayout();
        View view = LayoutInflater.from(mContext).inflate(mItemLayoutRes, parent, false);
        final BaseRecViewHolder holder = new BaseRecViewHolder(view);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int adapterPosition = (int) holder.getItemId();
//                if (onItemClickListener != null) {
//                    T data = null;
//                    if (adapterPosition < list.size()) {
//                        data = list.get(adapterPosition);
//                    }
//                    onItemClickListener.onItemClickDeal(holder,data, adapterPosition);
//                }
//            }
//        });

//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                int adapterPosition = (int) holder.getItemId();
//                if (onItemLongClickListener != null) {
//                    T data = null;
//                    if (adapterPosition < list.size()) {
//                        data = list.get(adapterPosition);
//                    }
//                    onItemLongClickListener.onItemLongClick(holder, data, adapterPosition);
//                }
//                return true;
//            }
//        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final BaseRecViewHolder holder, final int position) {
        final T data = list.get(position);
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickDeal(holder, data, position);
                }
            });
        }
        if (onItemLongClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemLongClickListener.onItemLongClick(holder, data, position);
                }
            });
        }
        onBindData(holder, data, position);
    }

    protected abstract int onBindLayout();

    protected abstract void onBindData(BaseRecViewHolder holder, T data, int position);

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLongClick(BaseRecViewHolder holder, T data, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }


    /**
     * 防止快速多次点击（如果不需要，请实现onItemClickDeal方法）
     */
    public static abstract class OnItemClickListener<T> {

        private long lastClickTime = 0;

        public void onItemClickDeal(BaseRecViewHolder holder, T data, int position) {
            long time = System.currentTimeMillis();
            if (time - lastClickTime < 1000) {
                return;
            }
            lastClickTime = time;
            onItemClick(holder, data, position);
        }

        public abstract void onItemClick(BaseRecViewHolder holder, T data, int position);
    }

    public void add(T t) {
        int position = list.size();
        list.add(t);
        notifyItemInserted(list.size() - 1);
        if (position == 0) {
            notifyDataSetChanged();
        } else {
            notifyItemInserted(list.size() - 1);
        }
    }

    public void addAll(List<T> addDatas) {
        if (addDatas == null) {
            return;
        }
        int position = list.size();
        list.addAll(addDatas);

        if (position == 0) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(position, addDatas.size());
        }
    }

    public void refresh(List<T> newDatas) {
        list.clear();
        if (newDatas != null && newDatas.size() > 0) {
            list.addAll(newDatas);
        }
        notifyDataSetChanged();
    }

    public void remove(int index) {
        int position = list.indexOf(index);
        if (position != -1) {
            list.remove(index);
            notifyItemRemoved(position);
        } else {
            Log.w("baseRecyclerAdapter", "移除的对象不存在");
        }
    }

    public void remove(T t) {
        int position = list.indexOf(t);
        if (position != -1) {
            list.remove(t);
            notifyItemRemoved(position);
        } else {
            Log.w("baseRecyclerAdapter", "移除的对象不存在");
        }
    }

    public T getItem(int position) {
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    public List<T> getListData() {
        return list;
    }

}
