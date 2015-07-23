package com.greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.greendao.Memo;

import com.greendao.MemoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig memoDaoConfig;

    private final MemoDao memoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        memoDaoConfig = daoConfigMap.get(MemoDao.class).clone();
        memoDaoConfig.initIdentityScope(type);

        memoDao = new MemoDao(memoDaoConfig, this);

        registerDao(Memo.class, memoDao);
    }
    
    public void clear() {
        memoDaoConfig.getIdentityScope().clear();
    }

    public MemoDao getMemoDao() {
        return memoDao;
    }

}
