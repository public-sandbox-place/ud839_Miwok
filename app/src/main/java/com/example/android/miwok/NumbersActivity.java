package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one", "two", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("one", "two", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("one", "two", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("one", "two", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("one", "two", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("one", "two", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("one", "two", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("one", "two", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("one", "two", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("one", "two", R.drawable.number_ten, R.raw.number_ten));

        ListView listView = findViewById(R.id.numbers_list);

        WordAdapter itemsAdapter = new WordAdapter(
                this, words, R.color.category_numbers
        );


        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getSong());
                mMediaPlayer.start();
                Toast.makeText(NumbersActivity.this, "Clicked item " + position


                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
