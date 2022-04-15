package com.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomwordsample.db.Word;
import com.example.roomwordsample.tab.WordListAdapter;
import com.example.roomwordsample.viewmodels.WordViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public WordViewModel mWordViewModel;
    private Button button_send;
    private EditText mEditWordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditWordView = findViewById(R.id.edit_word);
        button_send = findViewById(R.id.send);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);


            button_send.setOnClickListener(view -> {
                if (TextUtils.isEmpty(mEditWordView.getText())){
                    Toast.makeText(getApplicationContext(), "Impossible d'enregistrer une chaine vide", Toast.LENGTH_SHORT).show();
                }
                else {
                    String word1 = mEditWordView.getText().toString();
                    Word word = new Word(word1);
                    mWordViewModel.insert(word);
                    mEditWordView.setText("");
                }
            });
        });

        //final FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
//            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//        });
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
//            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
//            mWordViewModel.insert(word);
//        } else {
//            Toast.makeText(
//                    getApplicationContext(),
//                    R.string.empty_not_saved,
//                    Toast.LENGTH_LONG).show();
//        }
//    }
}