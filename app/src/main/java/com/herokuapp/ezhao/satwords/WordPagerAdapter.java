package com.herokuapp.ezhao.satwords;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Random;

public class WordPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Word> words;
    private int[] wordOrder;

    public WordPagerAdapter(FragmentManager fm, ArrayList<Word> words) {
        super(fm);
        this.words = words;
        wordOrder = new int[words.size()];
        for (int i=0; i<words.size(); i++) {
            wordOrder[i] = i;
        }
        Random random = new Random();
        for (int i=0; i<words.size(); i++) {
            int nextIndex = i + random.nextInt(words.size() - i);
            int nextValue = wordOrder[nextIndex];
            wordOrder[nextIndex] = wordOrder[i];
            wordOrder[i] = nextValue;
        }
    }

    @Override
    public Fragment getItem(int position) {
        Word word = words.get(wordOrder[position]);
        return WordFragment.newInstance(word);
    }

    @Override
    public int getCount() {
        return words.size();
    }
}
