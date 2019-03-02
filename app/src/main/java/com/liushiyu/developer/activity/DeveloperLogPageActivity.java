package com.liushiyu.developer.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.liushiyu.developer.DeveloperModelManager;
import com.liushiyu.developer.R;
import com.liushiyu.developer.core.storage.entry.DBTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeveloperLogPageActivity extends AppCompatActivity {

    private List<DBTest> logList;

    @BindView(R.id.logListView)
    ListView logListView;

    private DeveloperLogAdapter adapter;

    private Context context;

    private SimpleDateFormat DATE_FORMAT_YMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_page);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        context = getApplicationContext();

        logList = new ArrayList<>();
        adapter = new DeveloperLogAdapter();
        logListView.setAdapter(adapter);

        queryLogList();
    }

    private void queryLogList() {
        logList.clear();
        List<DBTest> dbTestList = DeveloperModelManager.getLog();

        if (dbTestList == null || dbTestList.size() == 0) {
            adapter.notifyDataSetChanged();
            return;
        }
        logList.addAll(dbTestList);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.logAddButton)
    public void logAddButtonClick() {
        DeveloperModelManager.setLog("DeveloperLogPageActivity", DATE_FORMAT_YMD.format(new Date()));
        queryLogList();
    }

    @OnClick(R.id.logQueryButton)
    public void logQueryButtonClick() {
        queryLogList();
    }

    @OnClick(R.id.logDeleteAllButton)
    public void logDeleteAllButtonClick() {
        DeveloperModelManager.deleteAllLog();
        queryLogList();
    }

    public class DeveloperLogAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return logList.size();
        }

        @Override
        public Object getItem(int position) {
            return logList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return logList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DeveloperLogViewHolder holder;

            if (convertView == null) {
                convertView = View.inflate(context, R.layout.adapter_developer_log_item, null);
                holder = new DeveloperLogViewHolder();
                holder.developerAdapterItemLogTag = convertView.findViewById(R.id.developerAdapterItemLogTag);
                holder.developerAdapterItemLogContent = convertView.findViewById(R.id.developerAdapterItemLogContent);
                convertView.setTag(holder);
            } else {
                holder = (DeveloperLogViewHolder) convertView.getTag();
            }

            holder.developerAdapterItemLogTag.setText(logList.get(position).getLogTag());
            holder.developerAdapterItemLogContent.setText(logList.get(position).getLogString());

            return convertView;
        }
    }

    public class DeveloperLogViewHolder {
        TextView developerAdapterItemLogTag;
        TextView developerAdapterItemLogContent;
    }
}
