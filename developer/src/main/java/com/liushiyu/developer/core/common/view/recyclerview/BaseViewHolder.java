package com.liushiyu.developer.core.common.view.recyclerview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * created by liushuai on 2018/11/9
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    private final Context mContext;
    private View root;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.root = itemView;
        mContext = itemView.getContext();
    }

    public BaseViewHolder(Context context, @LayoutRes int resource, @Nullable ViewGroup root) {
        this(context, resource, root, false);
    }

    public BaseViewHolder(Context context, @LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot) {

        this(LayoutInflater.from(context).inflate(resource, root, attachToRoot));
    }

    public Context getContext() {
        return mContext;
    }

    public View getRootView() {
        return root;
    }
}
