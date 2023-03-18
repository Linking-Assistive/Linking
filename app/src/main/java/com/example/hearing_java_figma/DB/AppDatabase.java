package com.example.hearing_java_figma.DB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hearing_java_figma.DAO.KeywordDao;
import com.example.hearing_java_figma.PO.Keyword;


@Database(entities = {Keyword.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "linking.db";
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = createDatabase(context);
        }
        return instance;
    }

    private static AppDatabase createDatabase(Context context) {
        return Room.databaseBuilder(context,AppDatabase.class,DB_NAME).addCallback(new RoomDatabase.Callback(){
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        }).build();
    }

    public abstract KeywordDao keywordDao();
}
