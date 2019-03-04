package com.liushiyu.developer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liushiyu.developer.DeveloperModelManager;
import com.liushiyu.developer.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeveloperLogTestActivity extends AppCompatActivity {

    private String TAG = "DeveloperLogTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test_page);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.logNormalButton)
    public void logNormalButtonClick() {
        DeveloperModelManager.setLog(TAG, "我是内容我是内容。。我是内容");
//        DeveloperModelManager.setNormalLog(TAG, "我是内容我是内容。。我是内容");
    }

    @OnClick(R.id.logWarnButton)
    public void logWarnButtonClick() {
        DeveloperModelManager.setWarnLog(TAG, "我是内容我是内容。。我是内容");
    }

    @OnClick(R.id.logErrorButton)
    public void logErrorButtonClick() {
        DeveloperModelManager.setErrorLog(TAG, "我是内容我是内容。。我是内容");
    }
}
