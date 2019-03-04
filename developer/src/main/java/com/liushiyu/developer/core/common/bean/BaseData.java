package com.liushiyu.developer.core.common.bean;

import com.liushiyu.developer.model.DeveloperLogModel;

public abstract class BaseData extends DeveloperLogModel {

    public static final int LOG_TYPE_NORMAL = 0;
    public static final int LOG_TYPE_WARN = 1;
    public static final int LOG_TYPE_ERROR = 2;

    public abstract int type();
}
