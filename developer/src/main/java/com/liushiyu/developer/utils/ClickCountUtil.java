package com.liushiyu.developer.utils;

import com.liushiyu.developer.DeveloperModelManager;
import com.liushiyu.developer.model.DeveloperStateModel;

/**
 * 点击计数工具
 */
public class ClickCountUtil {

    private int countNumber = 10;
    private int currentNumber = 0;

    public ClickCountUtil() {}

    public void setClickNumber(int countNumber) {
        this.countNumber = countNumber;
    }

    public void onClick() {
        currentNumber++;
        if (currentNumber == this.countNumber) {
            DeveloperModelManager.setDeveloperState(DeveloperStateModel.DEVELOPER_STATE_OPEN, true);
            currentNumber = 0;
        }
    }
}
