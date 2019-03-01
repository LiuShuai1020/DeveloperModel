package com.liushiyu.developer.presenter;

import com.liushiyu.developer.model.DeveloperStateModel;
import com.liushiyu.developer.utils.ClickCountUtil;

import static com.liushiyu.developer.model.DeveloperStateModel.DEVELOPER_STATE_OPEN;

public class DeveloperModelManagerPresenter {

    private ClickCountUtil clickCountUtil;

    private DeveloperStateModel developerStateModel;

    public DeveloperModelManagerPresenter() {
        clickCountUtil = new ClickCountUtil();
        developerStateModel = new DeveloperStateModel();
    }

    public void setClickNumber(int countNumber) {
        if (clickCountUtil != null) {
            clickCountUtil.setClickNumber(countNumber);
        }
    }

    public void onClick() {
        if (clickCountUtil != null) {
            clickCountUtil.onClick();
        }
    }

    public void setDeveloperState(int developerState) {
        if (developerStateModel != null) {
            developerStateModel.setDeveloperState(developerState, false);
        }
    }

    public void setDeveloperState(int developerState, boolean showHint) {
        if (developerStateModel != null) {
            developerStateModel.setDeveloperState(developerState, showHint);
        }
    }

    public boolean isDeveloperModel() {
        if (developerStateModel == null) {
            return false;
        }
        return developerStateModel.getDeveloperState() == DEVELOPER_STATE_OPEN;
    }
}
