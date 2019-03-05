package com.liushiyu.developer.utils;

import com.liushiyu.developer.core.common.bean.BaseData;
import com.liushiyu.developer.core.storage.DaoManager;
import com.liushiyu.developer.core.storage.DeveloperLogCacheDao;
import com.liushiyu.developer.core.storage.entry.DeveloperLogCache;
import com.liushiyu.developer.model.DeveloperLogModel;

import org.greenrobot.greendao.async.AsyncSession;
import org.greenrobot.greendao.query.QueryBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DBDeveloperUtils {
    private static final String DB_DEVELOPER_LOG_KEY = "db_developer_log_key";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);

    private AsyncSession mAsyncSession;

    public DBDeveloperUtils() {
        mAsyncSession = DaoManager.instance().getSession().startAsyncSession();
    }

    public void setDeveloperLogModelData(String logTag, String logString) {
        setDeveloperLogModelData(logTag, logString, BaseData.LOG_TYPE_NORMAL);
    }

    public void setDeveloperLogModelData(String logTag, String logString, int type) {
        DeveloperLogModel developerLogModel = new DeveloperLogModel();
        developerLogModel.setDeveloperLogTime(SIMPLE_DATE_FORMAT.format(new Date()));
        developerLogModel.setDeveloperLogTag(logTag);
        developerLogModel.setDeveloperLogContent(logString);
        developerLogModel.setDeveloperLogType(type);
        setDeveloperLogModelData(developerLogModel);
    }

    public void setDeveloperLogModelData(DeveloperLogModel developerLogModelData) {
        DeveloperLogCache cache = new DeveloperLogCache();
        cache.setKey(DB_DEVELOPER_LOG_KEY);
        cache.setDeveloperLogModel(developerLogModelData);
        mAsyncSession.insert(cache);
    }

    public List<DeveloperLogCache> getDeveloperLogModelData() {
        DeveloperLogCacheDao cacheDao = DaoManager.instance().getSession().getDeveloperLogCacheDao();
        QueryBuilder<DeveloperLogCache> builder = cacheDao.queryBuilder().where(DeveloperLogCacheDao.Properties.Key.eq(DB_DEVELOPER_LOG_KEY));
        return builder.list();
    }

    public void deleteDeveloperLogAllData() {
        mAsyncSession.deleteAll(DeveloperLogCache.class);
    }
}
