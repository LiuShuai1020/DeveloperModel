package com.liushiyu.developer.core.storage.entry;

import com.google.gson.Gson;
import com.liushiyu.developer.core.storage.DaoSession;
import com.liushiyu.developer.core.storage.DeveloperLogCacheDao;
import com.liushiyu.developer.model.DeveloperLogModel;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.converter.PropertyConverter;

@Entity(active = true, nameInDb = "com_liushiyu_developer_db_log")
public class DeveloperLogCache {
    @Id(autoincrement = true)
    private Long id;
    private String key;
    @Convert(converter = DeveloperLogModelConverter.class, columnType = String.class)
    private DeveloperLogModel developerLogModel;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1256442962)
    private transient DeveloperLogCacheDao myDao;

    @Generated(hash = 1889932646)
    public DeveloperLogCache(Long id, String key, DeveloperLogModel developerLogModel) {
        this.id = id;
        this.key = key;
        this.developerLogModel = developerLogModel;
    }

    @Generated(hash = 2137300358)
    public DeveloperLogCache() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DeveloperLogModel getDeveloperLogModel() {
        return this.developerLogModel;
    }

    public void setDeveloperLogModel(DeveloperLogModel developerLogModel) {
        this.developerLogModel = developerLogModel;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1333490888)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDeveloperLogCacheDao() : null;
    }

    public static class DeveloperLogModelConverter implements PropertyConverter<DeveloperLogModel, String> {

        @Override
        public DeveloperLogModel convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, DeveloperLogModel.class);
        }

        @Override
        public String convertToDatabaseValue(DeveloperLogModel entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }
}
