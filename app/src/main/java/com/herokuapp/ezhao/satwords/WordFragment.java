package com.herokuapp.ezhao.satwords;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class WordFragment extends Fragment {
    @InjectView(R.id.tvWord) TextView tvWord;
    @InjectView(R.id.tvDefinition) TextView tvDefinition;
    Word word;

    public static WordFragment newInstance(Word word) {
        WordFragment wordFragment = new WordFragment();
        Bundle args = new Bundle();
        args.putSerializable("word", word);
        wordFragment.setArguments(args);
        return wordFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        word = (Word) getArguments().getSerializable("word");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        ButterKnife.inject(this, view);

        if (word != null) {
            tvWord.setText(word.getWord());
            tvDefinition.setText(word.getDefinition());
        }

        return view;
    }
}
