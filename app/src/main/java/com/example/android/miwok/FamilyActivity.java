package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one1", "two"));
        words.add(new Word("one", "two1"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));
        words.add(new Word("one", "two"));


        //Log.v("Main Activity", words.toString());

        ListView listView = findViewById(R.id.family_list);

/*
        Not optimal approach for the long list!!!
        --------------------------------------------------
        for (int index = 0; index < words.size(); index++) {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            numberList.addView(wordView);
        }
*/
        WordAdapter itemsAdapter = new WordAdapter(
                this, words
        );

        listView.setAdapter(itemsAdapter);

    }
}
