package com.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MEMO.
 */
public class Memo {

    /** Not-null value. */
    private String Data;
    /** Not-null value. */
    private String DueDate;

    public Memo() {
    }

    public Memo(String Data, String DueDate) {
        this.Data = Data;
        this.DueDate = DueDate;
    }

    /** Not-null value. */
    public String getData() {
        return Data;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setData(String Data) {
        this.Data = Data;
    }

    /** Not-null value. */
    public String getDueDate() {
        return DueDate;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

}
