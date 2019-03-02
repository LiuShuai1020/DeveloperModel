package com.liushiyu.developer.presenter;

import com.liushiyu.developer.core.storage.entry.DBTest;
import com.liushiyu.developer.model.DeveloperStateModel;
import com.liushiyu.developer.utils.ClickCountUtil;
import com.liushiyu.developer.utils.DBDeveloperUtils;

import java.util.List;

import static com.liushiyu.developer.model.DeveloperStateModel.DEVELOPER_STATE_OPEN;

public class DeveloperModelManagerPresenter {

    private ClickCountUtil clickCountUtil;

    private DeveloperStateModel developerStateModel;

    private DBDeveloperUtils dbDeveloperUtils;

    public DeveloperModelManagerPresenter() {
        clickCountUtil = new ClickCountUtil();
        developerStateModel = new DeveloperStateModel();
        dbDeveloperUtils = new DBDeveloperUtils();
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

    public void setLog(String logTag, String logString) {
        if (dbDeveloperUtils != null) {
            dbDeveloperUtils.saveTestData(logTag, logString);
        }
    }

    public List<DBTest> getLog() {
        if (dbDeveloperUtils != null) {
            return dbDeveloperUtils.getTestData();
        }
        return null;
    }

    public void deleteAllLog() {
        if (dbDeveloperUtils != null) {
            dbDeveloperUtils.deleteAllLog();
        }
    }
}
