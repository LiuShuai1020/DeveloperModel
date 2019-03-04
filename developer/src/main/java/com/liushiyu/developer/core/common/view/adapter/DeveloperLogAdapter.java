package com.liushiyu.developer.core.common.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.liushiyu.developer.core.common.bean.BaseData;
import com.liushiyu.developer.core.common.presenter.LifecycleAdapterPresenter;
import com.liushiyu.developer.core.common.view.recyclerview.BaseViewHolder;
import com.liushiyu.developer.core.common.viewholder.ErrorStateViewHolder;
import com.liushiyu.developer.core.common.viewholder.LogBaseViewHolder;
import com.liushiyu.developer.core.common.viewholder.NormalStateViewHolder;
import com.liushiyu.developer.core.common.viewholder.WarnStateViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DeveloperLogAdapter extends LifecycleAdapterPresenter<BaseViewHolder> {

    private List<BaseData> logModelList = new ArrayList<>();

    public DeveloperLogAdapter(Context mContext) {
        super(mContext);
    }

    public void setLogModelList(List<BaseData> logModelList) {
        this.logModelList = logModelList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BaseData.LOG_TYPE_NORMAL) {
            return new NormalStateViewHolder(getContext(), parent);
        }
        if (viewType == BaseData.LOG_TYPE_WARN) {
            return new WarnStateViewHolder(getContext(), parent);
        }
        if (viewType == BaseData.LOG_TYPE_ERROR) {
            return new ErrorStateViewHolder(getContext(), parent);
        }
        return new NormalStateViewHolder(getContext(), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof LogBaseViewHolder) {
            (((LogBaseViewHolder) holder)).setData(logModelList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return logModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return logModelList.get(position).type();
    }
}
