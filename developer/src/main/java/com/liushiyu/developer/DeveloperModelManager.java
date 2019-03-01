package com.liushiyu.developer;

import android.content.Context;

import com.liushiyu.developer.presenter.DeveloperModelManagerPresenter;
import com.liushiyu.developer.utils.TooltipUtil;

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

    private static void ensure() {
        if (!isInit) {
            throw new NullPointerException("请执行初始化方法 Please execute code: DeveloperModelManager.init()");
        }
    }

    // 对外方法 - begin

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        isInit = true;
        TooltipUtil.init(context);
    }

    public static void setClickNumber(int countNumber) {
        ensure();
        getPresenter().setClickNumber(countNumber);
    }

    public static void onClick() {
        ensure();
        getPresenter().onClick();
    }

    public static void setDeveloperModelState(int developerState) {
        ensure();
        getPresenter().setDeveloperState(developerState);
    }

    public static void setDeveloperState(int developerState, boolean showHint) {
        ensure();
        getPresenter().setDeveloperState(developerState, showHint);
    }

    public static boolean isDeveloperModel() {
        ensure();
        return getPresenter().isDeveloperModel();
    }

    // 对外方法 - end
}
