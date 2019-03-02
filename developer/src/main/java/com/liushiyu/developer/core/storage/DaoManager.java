package com.liushiyu.developer.core.storage;

import android.content.Context;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import java.util.UUID;

import io.reactivex.Observable;

/**
 * created by liushuai on 2018/11/9
 */
public class DaoManager {
    private static volatile DaoManager sInstance;
    private static final String DB_NAME = "com_liushiyu_developer_db";

    private DaoSession mSession;

    private DaoManager(){}

    public static DaoManager instance(){
        if (sInstance == null){
            synchronized (DaoManager.class){
                if (sInstance == null){
                    sInstance = new DaoManager();
                }
            }
        }
        return sInstance;
    }

    public static void init(Context c){
        instance()._init(c);
    }

    private void _init(Context c){
        final Context context = c;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        Database database =
                helper.getEncryptedWritableDb(UUID.nameUUIDFromBytes(DB_NAME.getBytes()).toString());
        mSession = new DaoMaster(database).newSession();
    }

    /**
     * 获取数据库 session
     */
    public DaoSession getSession(){
        return checkNotNull(mSession, "please invoke init()");
    }

    /**
     * QueryBuilder 转 Observable.fromIterable
     */
    public static <T> Observable<T> queryBuilderToRxIterable(final QueryBuilder<T> queryBuilder){
        return Observable.defer(() -> Observable.fromIterable(queryBuilder.list()));
    }

    /**
     * QueryBuilder 转 Observable.just
     */
    public static <T> Observable<List<T>> queryBuilderToRxList(final QueryBuilder<T> queryBuilder){
        return Observable.defer(() -> Observable.just(queryBuilder.list()));
    }

    public static <T> T checkNotNull(T t, String cause){
        if (t == null){
            throw new NullPointerException(cause);
        }
        return t;
    }
}
