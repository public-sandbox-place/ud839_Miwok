package com.example.android.miwok;

import android.media.Image;

public class Word {
    private String mName1;
    private String mName2;
    private int mImageId = NO_IMAGE_PROVIDED;
    private int mSong = NO_SONG_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_SONG_PROVIDED = -1;

    Word(String name1, String name2) {
        mName1 = name1;
        mName2 = name2;
    }

    Word(String name1, String name2, int imgId) {
        mName1 = name1;
        mName2 = name2;
        mImageId = imgId;

    }

    Word(String name1, String name2, int imgId, int song) {
        mName1 = name1;
        mName2 = name2;
        mImageId = imgId;
        mSong = song;
    }



    public String getName1() {
        return mName1;
    }

    public String getName2() {
        return mName2;
    }

    public int getImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        return mImageId != NO_IMAGE_PROVIDED;
    }

    public boolean hasSong() {
        return mSong != NO_SONG_PROVIDED;
    }

    public int getSong() {
        return mSong;
    }
}
