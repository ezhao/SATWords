package com.herokuapp.ezhao.satwords;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Word implements Serializable {
    private String word;
    private String definition;

    public static ArrayList<Word> fromTxtFile(Activity activity) {
        ArrayList<Word> words = new ArrayList<>();

        try {
            // Get raw file from assets
            InputStream inputStream = activity.getAssets().open("vocab.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // Turn into Word objects
            String line = bufferedReader.readLine();
            while (line != null) {
                int wordBreak = line.indexOf(" ");
                String word = line.substring(0, wordBreak);
                String definition = line.substring(wordBreak+1);
                words.add(new Word(word, definition));
                line = bufferedReader.readLine();
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return words;
    }

    public Word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }
}
