package com.example.divum.auto_biography;

/**
 * Created by divum.
 */
public class ActorsEntity {
    String mName;
    int mAge;
    String mDesc;


    public ActorsEntity(String name,int age,String desc){
        mName=name;
        mAge=age;
        mDesc=desc;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }
}
