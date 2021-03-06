package com.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER.
 */
public class User {

    private long UserId;
    /** Not-null value. */
    private String Password;
    /** Not-null value. */
    private String Name;

    public User() {
    }

    public User(long UserId, String Password, String Name) {
        this.UserId = UserId;
        this.Password = Password;
        this.Name = Name;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long UserId) {
        this.UserId = UserId;
    }

    /** Not-null value. */
    public String getPassword() {
        return Password;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /** Not-null value. */
    public String getName() {
        return Name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String Name) {
        this.Name = Name;
    }

}
