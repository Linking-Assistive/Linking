package com.example.hearing_java_figma.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Update;

import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.VO.KeywordTuple;

import java.util.List;


@Dao
public interface KeywordDao {
    @Query("SELECT keyword_name, activated FROM keyword_table")
    LiveData<List<KeywordTuple>> loadKeywordInfo();

    @Query("SELECT * FROM keyword_table")
    LiveData<List<Keyword>> getAll();

    @Query("SELECT * FROM keyword_table where kid = :id")
    LiveData<Keyword> getKeywordById(int id);

    @Query("UPDATE keyword_table SET activated= :is_activated WHERE keyword_name= :name")
    void updateActivateByName(String name, boolean is_activated);

    @Update
    void update(Keyword... keywords);

    @Insert
    void insert(Keyword... keywords);

    @Delete
    void delete(Keyword... keywords);

    @Query("DELETE FROM keyword_table")
    void deleteAll();
}
