package com.example.hearing_java_figma.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.hearing_java_figma.DAO.KeywordDao;
import com.example.hearing_java_figma.DB.AppDatabase;
import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.VO.KeywordTuple;

import java.util.List;

public class KeywordRepository {
    private KeywordDao keywordDao;

    public KeywordRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        this.keywordDao = appDatabase.keywordDao();
    }

    public LiveData<List<KeywordTuple>> loadKeywordInfoLiveData(){
        return keywordDao.loadKeywordInfo();
    }

    public LiveData<List<Keyword>> getAllLiveData(){
        return keywordDao.getAll();
    }

    public void insertKeyword(Keyword... keywords){
        new InsertKeywordTask(keywordDao).execute(keywords);
    }

    public void deleteKeyword(Keyword... keywords){
        new DeleteKeywordTask(keywordDao).execute(keywords);
    }

    public void updateKeyword(Keyword... keywords){
        new UpdateKeywordTask(keywordDao).execute(keywords);
    }

    public void deleteAllKeywords(){
        new DeleteAllKeywordsTask(keywordDao).execute();
    }

    class InsertKeywordTask extends AsyncTask<Keyword, Void, Void>{

        private KeywordDao keywordDao;

        public InsertKeywordTask(KeywordDao keywordDao){
            this.keywordDao = keywordDao;
        }

        @Override
        protected Void doInBackground(Keyword... keywords) {
            keywordDao.insert(keywords);
            return null;
        }
    }

    class DeleteKeywordTask extends AsyncTask<Keyword, Void, Void>{

        private KeywordDao keywordDao;

        public DeleteKeywordTask(KeywordDao keywordDao){
            this.keywordDao = keywordDao;
        }

        @Override
        protected Void doInBackground(Keyword... keywords) {
            keywordDao.delete(keywords);
            return null;
        }
    }

    class UpdateKeywordTask extends AsyncTask<Keyword, Void, Void>{

        private KeywordDao keywordDao;

        public UpdateKeywordTask(KeywordDao keywordDao){
            this.keywordDao = keywordDao;
        }

        @Override
        protected Void doInBackground(Keyword... keywords) {
            keywordDao.update(keywords);
            return null;
        }
    }

    class DeleteAllKeywordsTask extends AsyncTask<Void, Void, Void>{

        private KeywordDao keywordDao;

        public DeleteAllKeywordsTask(KeywordDao keywordDao){
            this.keywordDao = keywordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            keywordDao.deleteAll();
            return null;
        }
    }
}
