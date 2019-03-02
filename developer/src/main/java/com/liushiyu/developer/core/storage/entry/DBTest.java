package com.liushiyu.developer.core.storage.entry;

import com.liushiyu.developer.core.storage.DBTestDao;
import com.liushiyu.developer.core.storage.DaoSession;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity(active = true, nameInDb = "com_liushiyu_developer_db_test")
public class DBTest {
    @Id(autoincrement = true)
    private Long id;

    private String key;

    private String logTag;
    private String logString;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1485698207)
    private transient DBTestDao myDao;
    @Generated(hash = 1876947797)
    public DBTest(Long id, String key, String logTag, String logString) {
        this.id = id;
        this.key = key;
        this.logTag = logTag;
        this.logString = logString;
    }
    @Generated(hash = 2069100866)
    public DBTest() {
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
    public String getLogTag() {
        return this.logTag;
    }
    public void setLogTag(String logTag) {
        this.logTag = logTag;
    }
    public String getLogString() {
        return this.logString;
    }
    public void setLogString(String logString) {
        this.logString = logString;
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
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1123991137)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getDBTestDao() : null;
    }
    
}
