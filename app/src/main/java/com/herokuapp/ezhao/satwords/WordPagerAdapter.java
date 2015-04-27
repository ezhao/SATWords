package com.herokuapp.ezhao.satwords;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class WordPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Word> words;

    public WordPagerAdapter(FragmentManager fm, ArrayList<Word> words) {
        super(fm);
        this.words = words;
    }

    @Override
    public Fragment getItem(int position) {
        Word word = words.get(position);
        return WordFragment.newInstance(word);
    }

    @Override
    public int getCount() {
        return words.size();
    }
}
