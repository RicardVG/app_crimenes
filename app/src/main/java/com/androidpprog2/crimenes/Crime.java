package com.androidpprog2.crimenes;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
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

    public boolean ismSolved() {
        return mSolved;
    }

    public void setSolved(boolean isChecked) {
        mSolved = isChecked;
    }
}
