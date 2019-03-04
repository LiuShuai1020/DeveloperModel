package com.liushiyu.developer;

import android.content.Context;

import com.liushiyu.developer.core.common.bean.BaseData;
import com.liushiyu.developer.core.storage.DaoManager;
import com.liushiyu.developer.model.DeveloperLogModel;
import com.liushiyu.developer.presenter.DeveloperModelManagerPresenter;
import com.liushiyu.developer.utils.TooltipUtil;

import java.util.List;

public class DeveloperModelManager {

    private static DeveloperModelManagerPresenter presenter;
    private static boolean isInit = false;

    private DeveloperModelManager() {
    }

    private static DeveloperModelManagerPresenter getPresenter() {
        if (DeveloperModelManager.presenter == null) {
            DeveloperModelManager.presenter = new DeveloperModelManagerPresenter();
        }
        return DeveloperModelManager.presenter;
    }

    /**
     * 检测是否已经初始化
     */
    private static void ensure() {
        if (!isInit) {
            throw new NullPointerException("请执行初始化方法 Please execute code: DeveloperModelManager.init()");
        }
    }

    static void setDeveloperLogView(DeveloperLogView developerLogView) {
        ensure();
        getPresenter().setDeveloperLogView(developerLogView);
    }

    // 对外方法 - begin

    /**
     * 初始化
     */
    public static void init(Context context) {
        if (context == null) {
            return;
        }
        isInit = true;
        TooltipUtil.init(context);
        DaoManager.init(context);
    }

    /**
     * 设置点击次数来开启开发者模式，默认点击10次
     */
    public static void setClickNumber(int countNumber) {
        ensure();
        getPresenter().setClickNumber(countNumber);
    }

    /**
     * 开发者模式开关
     */
    public static void onClick() {
        ensure();
        getPresenter().onClick();
    }

    /**
     * 直接设置开发者模式，跳过 setClickNumber , onClick 方法
     * DeveloperStateModel.DEVELOPER_STATE_OPEN
     * or
     * DeveloperStateModel.DEVELOPER_STATE_CLOSE
     */
    public static void setDeveloperModelState(int developerState) {
        ensure();
        getPresenter().setDeveloperState(developerState);
    }

    /**
     * 直接设置开发者模式，跳过 setClickNumber , onClick 方法
     * DeveloperStateModel.DEVELOPER_STATE_OPEN
     * or
     * DeveloperStateModel.DEVELOPER_STATE_CLOSE
     * <p>
     * showHint 是否显示"您已进入开发者模式" or "您已退出开发者模式"
     */
    public static void setDeveloperState(int developerState, boolean showHint) {
        ensure();
        getPresenter().setDeveloperState(developerState, showHint);
    }

    /**
     * 判断当前是否是开发者模式
     * true 表示是开发者模式
     * false 表示当前非开发者模式
     */
    public static boolean isDeveloperModel() {
        ensure();
        return getPresenter().isDeveloperModel();
    }

    /**
     * 需要在Log页面展示的数据，默认是正常状态
     */
    public static void setLog(String logTag, String logString) {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().setLog(logTag, logString);
    }

    /**
     * 需要在Log页面展示的数据，警告信息
     */
    public static void setNormalLog(String logTag, String logString) {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().setLog(logTag, logString, BaseData.LOG_TYPE_NORMAL);
    }

    /**
     * 需要在Log页面展示的数据，警告信息
     */
    public static void setWarnLog(String logTag, String logString) {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().setLog(logTag, logString, BaseData.LOG_TYPE_WARN);
    }

    /**
     * 需要在Log页面展示的数据，错误信息
     */
    public static void setErrorLog(String logTag, String logString) {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().setLog(logTag, logString, BaseData.LOG_TYPE_ERROR);
    }

    /**
     * 需要在Log页面展示的数据
     * <p>
     * type 日志类型：
     * <p>
     * BaseData.LOG_TYPE_NORMAL 正常信息
     * BaseData.LOG_TYPE_WARN   警告信息
     * BaseData.LOG_TYPE_ERROR  错误信息
     */
    public void setLog(String logTag, String logString, int type) {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().setLog(logTag, logString, type);
    }

    /**
     * 用户自定义展示页面，获取当前存储的日志信息list
     */
    public static List<DeveloperLogModel> getLog() {
        if (!isDeveloperModel()) {
            return null;
        }
        return getPresenter().getDeveloperLogModels();
    }

    /**
     * 用户自定义展示页面，删除所有log
     */
    public static void deleteAllLog() {
        if (!isDeveloperModel()) {
            return;
        }
        getPresenter().deleteAllLog();
    }

    // 对外方法 - end
}
