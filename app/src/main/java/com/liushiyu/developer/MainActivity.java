package com.liushiyu.developer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.initButton)
    public void initButtonClick() {
        DeveloperModelManager.init(this);
    }

    @OnClick(R.id.clickButton)
    public void clickButtonClick() {
        DeveloperModelManager.onClick();
    }
}
