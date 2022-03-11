package com.example.roomwordsample.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomwordsample.dao.WordDao;
import com.example.roomwordsample.db.Word;
import com.example.roomwordsample.db.WordRoomDatabase;


import java.util.List;

public class WordRepository {

    public WordDao mWordDao;
    public LiveData<List<Word>> mAllWords;


    public WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(()->{
            mWordDao.insert(word);
        });
    }
}
