package com.liushiyu.developer.model;

import com.liushiyu.developer.utils.TooltipUtil;

public class DeveloperStateModel {

    public static final int DEVELOPER_STATE_OPEN = 0;
    public static final int DEVELOPER_STATE_CLOSE = 1;
    private int developerState = DEVELOPER_STATE_CLOSE;

    public int getDeveloperState() {
        return developerState;
    }

    public void setDeveloperState(int developerState, boolean showHint) {
        ensure(developerState);
        this.developerState = developerState;
        if (developerState == DEVELOPER_STATE_OPEN && showHint) {
            TooltipUtil.toast("您已进入开发者模式!");
        }
        if (developerState == DEVELOPER_STATE_CLOSE && showHint) {
            TooltipUtil.toast("您已退出开发者模式!");
        }
    }

    public void setDeveloperState(int developerState, String hintContent) {
        ensure(developerState);
        this.developerState = developerState;
        if (hintContent != null && !hintContent.equals("") && hintContent.length() > 0) {
            TooltipUtil.toast(hintContent);
        }
    }

    private void ensure(int developerState) {
        if (developerState != DEVELOPER_STATE_OPEN) {
            if (developerState != DEVELOPER_STATE_CLOSE) {
                throw new NumberFormatException("DeveloperStateModel --> developerState Must is : DeveloperStateModel.DEVELOPER_STATE_OPEN or DeveloperStateModel.DEVELOPER_STATE_CLOSE");
            }
        }
    }
}
