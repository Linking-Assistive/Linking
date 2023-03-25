package com.example.hearing_java_figma.VM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.Repository.KeywordRepository;
import com.example.hearing_java_figma.VO.KeywordTuple;

import java.util.List;

public class KeywordViewModel extends AndroidViewModel {
    private KeywordRepository keywordRepository;

    public KeywordViewModel(@NonNull Application application) {
        super(application);
        this.keywordRepository = new KeywordRepository(application);
    }

    public LiveData<List<KeywordTuple>> loadKeywordInfoLiveData(){
        return keywordRepository.loadKeywordInfoLiveData();
    }

    public void insertKeyword(Keyword... keywords){
        keywordRepository.insertKeyword(keywords);
    }

    public void deleteKeyword(Keyword... keywords){
        keywordRepository.deleteKeyword(keywords);
    }

    public void updateKeyword(Keyword... keywords){
        keywordRepository.updateKeyword(keywords);
    }

    public void deleteAllKeywords(){
        keywordRepository.deleteAllKeywords();
    }
}
