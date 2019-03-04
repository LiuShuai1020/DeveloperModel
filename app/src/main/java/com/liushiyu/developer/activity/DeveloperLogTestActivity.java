package com.liushiyu.developer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liushiyu.developer.DeveloperModelManager;
import com.liushiyu.developer.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeveloperLogTestActivity extends AppCompatActivity {

    private SimpleDateFormat DATE_FORMAT_YMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private String TAG = "DeveloperLogTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_test_page);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.logNormalButton)
    public void logNormalButtonClick() {
        DeveloperModelManager.setLog(TAG, "我是内容我是内容。。我是内容 " + DATE_FORMAT_YMD.format(new Date()));
//        DeveloperModelManager.setNormalLog(TAG, "我是内容我是内容。。我是内容 " + DATE_FORMAT_YMD.format(new Date()));
    }

    @OnClick(R.id.logWarnButton)
    public void logWarnButtonClick() {
        DeveloperModelManager.setWarnLog(TAG, "我是内容我是内容。。我是内容 " + DATE_FORMAT_YMD.format(new Date()));
    }

    @OnClick(R.id.logErrorButton)
    public void logErrorButtonClick() {
        DeveloperModelManager.setErrorLog(TAG, "我是内容我是内容。。我是内容 " + DATE_FORMAT_YMD.format(new Date()));
    }
}
