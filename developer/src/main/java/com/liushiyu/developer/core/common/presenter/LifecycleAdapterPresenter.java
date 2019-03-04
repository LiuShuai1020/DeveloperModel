package com.liushiyu.developer.core.common.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * created by liushuai on 2018/11/9
 */
public abstract class LifecycleAdapterPresenter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private final Context mContext;

    protected LifecycleAdapterPresenter(Context mContext) {
        this.mContext = mContext;
    }

    protected Context getContext() {
        return mContext;
    }

}
