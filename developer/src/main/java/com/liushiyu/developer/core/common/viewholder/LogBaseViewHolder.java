package com.liushiyu.developer.core.common.viewholder;

import android.content.Context;
import android.view.ViewGroup;

import com.liushiyu.developer.core.common.view.recyclerview.BaseViewHolder;

public abstract class LogBaseViewHolder<T> extends BaseViewHolder {

    public LogBaseViewHolder(Context context, int resource, ViewGroup root) {
        super(context, resource, root);
    }

    public abstract void setData(T data);
}
