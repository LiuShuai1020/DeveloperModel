package com.liushiyu.developer.utils;

import com.liushiyu.developer.core.storage.DBTestDao;
import com.liushiyu.developer.core.storage.DaoManager;
import com.liushiyu.developer.core.storage.entry.DBTest;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DBDeveloperUtils {
    private static final String DB_TEST_KEY = "db_test_key";

    public DBDeveloperUtils(){}

    public void saveTestData(String lotTag, String logString) {
        DBTest cache = new DBTest();
        cache.setKey(DB_TEST_KEY);
        cache.setLogTag(lotTag);
        cache.setLogString(logString);
        DaoManager.instance().getSession().getDBTestDao().insert(cache);
    }

    public List<DBTest> getTestData() {
        DBTestDao cacheDao = DaoManager.instance().getSession().getDBTestDao();
        QueryBuilder<DBTest> builder = cacheDao.queryBuilder().where(DBTestDao.Properties.Key.eq(DB_TEST_KEY));
        return builder.list();
    }

    public void deleteAllLog() {
        DBTestDao cacheDao = DaoManager.instance().getSession().getDBTestDao();
        QueryBuilder<DBTest> builder = cacheDao.queryBuilder().where(DBTestDao.Properties.Key.eq(DB_TEST_KEY));

        List<DBTest> cacheList = builder.list();
        for (int i = 0; i < cacheList.size(); i++) {
            cacheDao.delete(cacheList.get(i));
        }
    }
}
