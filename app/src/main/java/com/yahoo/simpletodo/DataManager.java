package com.yahoo.simpletodo;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import com.greendao.DaoMaster;
import com.greendao.DaoSession;
import com.greendao.Memo;
import com.greendao.MemoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinze on 7/23/15.
 */
public class DataManager {
    public ArrayList<String> items;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private MemoDao memoDao;
    private Activity main;
    public static DataManager dataManager;

    public DataManager(Activity main) {
        this.main = main;
        setUpDao();
        daoReadItems();
    }

    private void setUpDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(main, "Memo", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        memoDao = daoSession.getMemoDao();
        DataManager.dataManager = this;
    }


    private void daoReadItems() {
        List<Memo> memos = memoDao.queryBuilder().list();
        items = new ArrayList<String>();
        for(Memo memo: memos) {
            items.add(memo.getData());
        }
    }

    public void daoWriteItems() {
        memoDao.deleteAll();
        for(String item: items) {
            addMemo(item, item);
        }
    }

    public void addMemo(String text, String date) {
        Memo memo = new Memo(text, date);
        memoDao.insert(memo);
    }
}
