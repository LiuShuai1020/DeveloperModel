package com.liushiyu.developer.presenter;

import com.liushiyu.developer.DeveloperLogView;
import com.liushiyu.developer.core.storage.entry.DeveloperLogCache;
import com.liushiyu.developer.model.DeveloperLogModel;
import com.liushiyu.developer.model.DeveloperStateModel;
import com.liushiyu.developer.utils.ClickCountUtil;
import com.liushiyu.developer.utils.DBDeveloperUtils;

import java.util.ArrayList;
import java.util.List;

import static com.liushiyu.developer.model.DeveloperStateModel.DEVELOPER_STATE_OPEN;

public class DeveloperModelManagerPresenter {

    private ClickCountUtil clickCountUtil;

    private DeveloperStateModel developerStateModel;

    private DBDeveloperUtils dbDeveloperUtils;

    private DeveloperLogView developerLogView;

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

    public void setDeveloperLogView(DeveloperLogView developerLogView) {
        this.developerLogView = developerLogView;
    }

    private void queryLog() {
        if (developerLogView != null) {
            developerLogView.queryLogList();
        }
    }

    public void setLog(String logTag, String logString) {
        if (dbDeveloperUtils != null) {
            dbDeveloperUtils.setDeveloperLogModelData(logTag, logString);
        }
        queryLog();
    }

    public void setLog(String logTag, String logString, int type) {
        if (dbDeveloperUtils != null) {
            dbDeveloperUtils.setDeveloperLogModelData(logTag, logString, type);
        }
        queryLog();
    }

    public List<DeveloperLogModel> getDeveloperLogModels() {
        if (dbDeveloperUtils != null) {
            List<DeveloperLogCache> logCacheList = dbDeveloperUtils.getDeveloperLogModelData();
            List<DeveloperLogModel> developerLogModelList = new ArrayList<>();
            for (int i = 0; i < logCacheList.size(); i++) {
                DeveloperLogCache cache = logCacheList.get(i);
                developerLogModelList.add(cache.getDeveloperLogModel());
            }

            return developerLogModelList;
        }
        return null;
    }

    public void deleteAllLog() {
        if (dbDeveloperUtils != null) {
            dbDeveloperUtils.deleteDeveloperLogAllData();
        }
    }
}
