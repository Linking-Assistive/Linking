package com.example.hearing_java_figma.VO;

import androidx.room.ColumnInfo;

public class KeywordTuple {
    @ColumnInfo(name = "keyword_name")
    private String name;

    @ColumnInfo(name = "activated")
    private boolean isActivated;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public String toString() {
        return "KeywordTuple{" +
                "name='" + name + '\'' +
                ", isActivated=" + isActivated +
                '}';
    }
}
