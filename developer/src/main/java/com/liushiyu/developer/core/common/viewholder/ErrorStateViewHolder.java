package com.liushiyu.developer.core.common.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liushiyu.developer.R;
import com.liushiyu.developer.core.common.bean.ErrorData;

public class ErrorStateViewHolder extends LogBaseViewHolder<ErrorData> {

    private TextView developerAdapterItemLogTag;
    private TextView developerAdapterItemLogContent;

    public ErrorStateViewHolder(Context context, ViewGroup root) {
        super(context, R.layout.adapter_log_item_error, root);
        init(getRootView());
    }

    private void init(View root) {
        developerAdapterItemLogTag = root.findViewById(R.id.developerAdapterItemLogTag);
        developerAdapterItemLogContent = root.findViewById(R.id.developerAdapterItemLogContent);
    }

    @Override
    public void setData(ErrorData data) {
        developerAdapterItemLogTag.setText(data.getDeveloperLogTag());
        developerAdapterItemLogContent.setText(data.getDeveloperLogContent());
    }
}
