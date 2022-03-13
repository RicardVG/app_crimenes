package com.androidpprog2.crimenes;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mState;

    public Crime(String mTitle, boolean mState){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getmId() {
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
