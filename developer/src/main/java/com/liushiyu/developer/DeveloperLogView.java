package com.liushiyu.developer;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liushiyu.developer.core.common.bean.BaseData;
import com.liushiyu.developer.core.common.bean.ErrorData;
import com.liushiyu.developer.core.common.bean.NormalData;
import com.liushiyu.developer.core.common.bean.WarnData;
import com.liushiyu.developer.core.common.view.adapter.DeveloperLogAdapter;
import com.liushiyu.developer.core.common.view.recyclerview.MGridLayoutManager;
import com.liushiyu.developer.core.common.view.recyclerview.MRecyclerView;
import com.liushiyu.developer.model.DeveloperLogModel;

import java.util.ArrayList;
import java.util.List;

public class DeveloperLogView extends LinearLayout {

    private MRecyclerView listView;

    private DeveloperLogAdapter adapter;

    private List<BaseData> logModelList = new ArrayList<>();

    public DeveloperLogView(Context context) {
        super(context);
        init(context);
    }

    public DeveloperLogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DeveloperLogView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View root = View.inflate(getContext(), R.layout.developer_log_view, this);
        initView(root);
        adapter = new DeveloperLogAdapter(context);
        listView.setAdapter(adapter);

        MGridLayoutManager mGridLayoutManager = new MGridLayoutManager(getContext(), 3);
        mGridLayoutManager.setSpanSizeLookup(new SpanSizeLookup());
        listView.setLayoutManager(mGridLayoutManager);

        queryLogList();
    }

    private void initView(View root) {
        listView = root.findViewById(R.id.logListView);
        Button logQueryButton = root.findViewById(R.id.logQueryButton);
        Button logDeleteAllButton = root.findViewById(R.id.logDeleteAllButton);

        logQueryButton.setOnClickListener(this::logQueryButtonClick);
        logDeleteAllButton.setOnClickListener(this::logDeleteAllButtonClick);
    }

    public void logQueryButtonClick(View v) {
        queryLogList();
    }

    public void logDeleteAllButtonClick(View v) {
        DeveloperModelManager.deleteAllLog();
        queryLogList();
    }

    public void queryLogList() {
        logModelList.clear();
        List<DeveloperLogModel> dbTestList = DeveloperModelManager.getLog();

        if (dbTestList == null || dbTestList.size() == 0) {
            adapter.notifyDataSetChanged();
            return;
        }

        List<BaseData> mList = new ArrayList<>();

        for (DeveloperLogModel model : dbTestList) {
            switch (model.getDeveloperLogType()) {
                case BaseData.LOG_TYPE_NORMAL:
                    NormalData normalData = new NormalData();
                    normalData.setDeveloperLogTime(model.getDeveloperLogTime());
                    normalData.setDeveloperLogType(model.getDeveloperLogType());
                    normalData.setDeveloperLogTag(model.getDeveloperLogTag());
                    normalData.setDeveloperLogContent(model.getDeveloperLogContent());
                    mList.add(normalData);
                    break;
                case BaseData.LOG_TYPE_WARN:
                    WarnData warnData = new WarnData();
                    warnData.setDeveloperLogTime(model.getDeveloperLogTime());
                    warnData.setDeveloperLogType(model.getDeveloperLogType());
                    warnData.setDeveloperLogTag(model.getDeveloperLogTag());
                    warnData.setDeveloperLogContent(model.getDeveloperLogContent());
                    mList.add(warnData);
                    break;
                case BaseData.LOG_TYPE_ERROR:
                    ErrorData errorData = new ErrorData();
                    errorData.setDeveloperLogTime(model.getDeveloperLogTime());
                    errorData.setDeveloperLogType(model.getDeveloperLogType());
                    errorData.setDeveloperLogTag(model.getDeveloperLogTag());
                    errorData.setDeveloperLogContent(model.getDeveloperLogContent());
                    mList.add(errorData);
                    break;
            }
        }

        logModelList.addAll(mList);
        adapter.setLogModelList(logModelList);
        adapter.notifyDataSetChanged();
    }

    private class SpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
        @Override
        public int getSpanSize(int position) {
            return 3;
        }
    }
}
