package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;

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
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(
                        mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT
                );
                Log.v("MainActivity", "FOCUS VALUE IS: " + result);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Log.v("MainActivity", "AUDIO GRANTED");
                    //mAudioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, words.get(position).getSong());
                    mMediaPlayer.start();
                }


                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(NumbersActivity.this, "I FINISHED", Toast.LENGTH_SHORT).show();
                        releaseMediaPlayer();


                    }
                });
                Toast.makeText(NumbersActivity.this, words.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        mOnAudioFocusChangeListener =
                new AudioManager.OnAudioFocusChangeListener() {
                    public void onAudioFocusChange(int focusChange) {

                        Log.v("MainActivity", "onAudioFocusChange: " + focusChange);
                        if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            // Pause playback because your Audio Focus was
                            // temporarily stolen, but will be back soon.
                            // i.e. for a phone call
                        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                            // Stop playback, because you lost the Audio Focus.
                            // i.e. the user started some other playback app
                            // Remember to unregister your controls/buttons here.
                            // And release the kra — Audio Focus!
                            // You’re done.
                            releaseMediaPlayer();
                        } else if (focusChange ==
                                AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                            // Lower the volume, because something else is also
                            // playing audio over you.
                            // i.e. for notifications or navigation directions
                            // Depending on your audio playback, you may prefer to
                            // pause playback here instead. You do you.
                        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                            mMediaPlayer.start();
                            // Resume playback, because you hold the Audio Focus
                            // again!
                            // i.e. the phone call ended or the nav directions
                            // are finished
                            // If you implement ducking and lower the volume, be
                            // sure to return it to normal here, as well.
                        }
                    }
                };


    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


}
