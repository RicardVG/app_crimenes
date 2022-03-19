package com.androidpprog2.crimenes;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Task {

    private String mId;
    private String mTitle;
    private Date mDate;
    private boolean mState;

    public Task(String title, boolean mState){
        mId = UUID.randomUUID().toString();
        mDate = new Date();
        mTitle = title;

    }


    public String getmId() {
        return mId;
    }

    public String getmTitle(){
        return mTitle;
    }

    public void setmTitle(String title){
        mTitle = title;
    }

    public Date getmDate(){
        return mDate;
    }

    public boolean ismState() {
        return mState;
    }

    public void setmState(boolean mState) {
        this.mState = mState;
    }
}
