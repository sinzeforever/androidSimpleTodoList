package com.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.greendao.Memo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MEMO.
*/
public class MemoDao extends AbstractDao<Memo, Void> {

    public static final String TABLENAME = "MEMO";

    /**
     * Properties of entity Memo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Data = new Property(0, String.class, "Data", false, "DATA");
        public final static Property DueDate = new Property(1, String.class, "DueDate", false, "DUE_DATE");
    };


    public MemoDao(DaoConfig config) {
        super(config);
    }
    
    public MemoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MEMO' (" + //
                "'DATA' TEXT NOT NULL ," + // 0: Data
                "'DUE_DATE' TEXT NOT NULL );"); // 1: DueDate
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MEMO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Memo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getData());
        stmt.bindString(2, entity.getDueDate());
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Memo readEntity(Cursor cursor, int offset) {
        Memo entity = new Memo( //
            cursor.getString(offset + 0), // Data
            cursor.getString(offset + 1) // DueDate
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Memo entity, int offset) {
        entity.setData(cursor.getString(offset + 0));
        entity.setDueDate(cursor.getString(offset + 1));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Memo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Memo entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
