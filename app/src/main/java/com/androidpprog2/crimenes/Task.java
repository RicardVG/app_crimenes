package com.androidpprog2.crimenes;

import java.util.UUID;

public class Task {

    private String mId;
    private String mTitle;
    private boolean mState;

    public Task(String title, boolean mState){
        mId = UUID.randomUUID().toString();
        mTitle = title;
        this.mState = mState;
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

    public boolean ismState() {
        return mState;
    }

    public void setmState(boolean mState) {
        this.mState = mState;
    }
}
