package com.example.hearing_java_figma.PO;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "keyword_table")
public class Keyword {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "kid")
    public int id;

    @ColumnInfo(name = "keyword_name")
    @NonNull
    public String name;

    @ColumnInfo(name = "activated")
    public boolean isActivated;

    public Keyword(){

    }

    public Keyword(@NonNull String n, boolean act) {
        name = n;
        isActivated = act;
    }

    @NonNull
    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActivated=" + isActivated +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
