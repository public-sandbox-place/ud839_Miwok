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

        ArrayList<String> words = new ArrayList<>();

        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        words.add("one1");
        words.add("two1");
        words.add("three1");
        words.add("four1");
        words.add("five1");
        words.add("six1");
        words.add("seven1");
        words.add("eight1");
        words.add("nine1");
        words.add("ten1");

        Log.v("Main Activity", words.toString());

        GridView gridView = findViewById(R.id.numbers_list);

/*
        Not optimal approach for the long list!!!
        --------------------------------------------------
        for (int index = 0; index < words.size(); index++) {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            numberList.addView(wordView);
        }
*/
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, words
        );

        gridView.setAdapter(itemsAdapter);
    }
}
