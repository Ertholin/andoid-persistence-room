package com.example.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class NewWordActivity extends AppCompatActivity {



    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditWordView;
    private Button button_send;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditWordView = findViewById(R.id.edit_word);


        button_send = findViewById(R.id.send);
        button_send.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Essai f", Toast.LENGTH_SHORT).show();
        });

//        button_send.setOnClickListener(view -> {
//            Intent replyIntent = new Intent();
//            if (TextUtils.isEmpty(mEditWordView.getText())) {
//                setResult(RESULT_CANCELED, replyIntent);
//            } else {
//                String word = mEditWordView.getText().toString();
//                replyIntent.putExtra(EXTRA_REPLY, word);
//                setResult(RESULT_OK, replyIntent);
//            }
//            finish();
//        });
    }
}