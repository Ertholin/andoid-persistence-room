package com.example.roomwordsample.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.example.roomwordsample.db.Word;
import com.example.roomwordsample.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    public LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        mAllWords = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords (){
        return  mAllWords;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }


}
