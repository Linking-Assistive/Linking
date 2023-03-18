package com.example.hearing_java_figma.Service;

import android.util.Log;

import com.example.hearing_java_figma.DAO.KeywordDao;
import com.example.hearing_java_figma.DB.AppDatabase;
import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.VO.KeywordTuple;

import java.util.Iterator;
import java.util.List;

public class KeywordService {
    public AppDatabase database;
    public KeywordDao keywordDao;

    public KeywordService(AppDatabase db){
        database = db;
        keywordDao = db.keywordDao();
    }

    public void clearKeywords(){
        List<Keyword> oldKeywords = keywordDao.getAll();
        keywordDao.deleteAll(oldKeywords);
    }

    public void insertPredefinedKeywords(){
        Keyword kw1 = new Keyword("watch out", true);
        Keyword kw2 = new Keyword("2514", false);
        Keyword kw3 = new Keyword("help", true);
        keywordDao.insertAll(kw1, kw2, kw3);
    }

    public List<KeywordTuple> showAllKeywords(){
        List<KeywordTuple> keywords = keywordDao.loadKeywordInfo();
        return keywords;
    }

    public void printToLogcat(List<KeywordTuple> keywords, String logcatTag){
        for (KeywordTuple keyword : keywords) {
            Log.i(logcatTag, keyword.toString());
        }
    }

}
