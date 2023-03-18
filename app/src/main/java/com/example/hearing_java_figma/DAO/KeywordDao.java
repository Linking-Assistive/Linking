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
    @Query("SELECT keyword_name, activated FROM keyword")
    List<KeywordTuple> loadKeywordInfo();

    @Query("SELECT * FROM keyword")
    List<Keyword> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Keyword keyword);

    @Query("UPDATE keyword SET activated= :is_activated WHERE keyword_name= :name")
    void updateActivateByName(String name, boolean is_activated);

    @Insert
    void insertAll(Keyword... keywords);

    @Delete
    void delete(Keyword keyword);

    @Delete
    void deleteAll(List<Keyword> keywords);
}
