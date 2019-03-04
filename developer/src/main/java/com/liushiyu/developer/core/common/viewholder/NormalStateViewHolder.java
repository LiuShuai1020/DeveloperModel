package com.liushiyu.developer.core.common.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liushiyu.developer.R;
import com.liushiyu.developer.core.common.bean.NormalData;

public class NormalStateViewHolder extends LogBaseViewHolder<NormalData> {
    private TextView developerAdapterItemLogTag;
    private TextView developerAdapterItemLogTime;
    private TextView developerAdapterItemLogContent;

    public NormalStateViewHolder(Context context, ViewGroup root) {
        super(context, R.layout.adapter_log_item_normal, root);
        init(getRootView());
    }

    private void init(View root) {
        developerAdapterItemLogTag = root.findViewById(R.id.developerAdapterItemLogTag);
        developerAdapterItemLogTime = root.findViewById(R.id.developerAdapterItemLogTime);
        developerAdapterItemLogContent = root.findViewById(R.id.developerAdapterItemLogContent);
    }

    @Override
    public void setData(NormalData data) {
        developerAdapterItemLogTag.setText(data.getDeveloperLogTag());
        developerAdapterItemLogTime.setText(data.getDeveloperLogTime());
        developerAdapterItemLogContent.setText(data.getDeveloperLogContent());
    }
}
