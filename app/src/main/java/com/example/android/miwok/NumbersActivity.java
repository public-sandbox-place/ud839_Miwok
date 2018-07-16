package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "two", R.drawable.number_one));
        words.add(new Word("one", "two", R.drawable.number_two));
        words.add(new Word("one", "two", R.drawable.number_three));
        words.add(new Word("one", "two", R.drawable.number_four));
        words.add(new Word("one", "two", R.drawable.number_five));
        words.add(new Word("one", "two", R.drawable.number_six));
        words.add(new Word("one", "two", R.drawable.number_seven));
        words.add(new Word("one", "two", R.drawable.number_eight));
        words.add(new Word("one", "two", R.drawable.number_nine));
        words.add(new Word("one", "two", R.drawable.number_ten));
        words.add(new Word("one", "two", R.drawable.number_two));
        words.add(new Word("one", "two", R.drawable.number_two));



        //Log.v("Main Activity", words.toString());

        ListView listView = findViewById(R.id.numbers_list);

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
                this, words, R.color.category_numbers
        );

        listView.setAdapter(itemsAdapter);
    }
}
