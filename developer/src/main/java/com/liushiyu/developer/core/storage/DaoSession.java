package com.liushiyu.developer.core.storage;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.liushiyu.developer.core.storage.entry.DeveloperLogCache;

import com.liushiyu.developer.core.storage.DeveloperLogCacheDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig developerLogCacheDaoConfig;

    private final DeveloperLogCacheDao developerLogCacheDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        developerLogCacheDaoConfig = daoConfigMap.get(DeveloperLogCacheDao.class).clone();
        developerLogCacheDaoConfig.initIdentityScope(type);

        developerLogCacheDao = new DeveloperLogCacheDao(developerLogCacheDaoConfig, this);

        registerDao(DeveloperLogCache.class, developerLogCacheDao);
    }
    
    public void clear() {
        developerLogCacheDaoConfig.clearIdentityScope();
    }

    public DeveloperLogCacheDao getDeveloperLogCacheDao() {
        return developerLogCacheDao;
    }

}
