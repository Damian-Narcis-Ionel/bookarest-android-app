package com.example.bookarest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class fragment_my_books extends Fragment {

    ImageView wtr1;
    ImageView wtr2;
    ImageView wtr3;
    ImageView cr1;
    ImageView cr2;
    ImageView cr3;
    ImageView r1;
    ImageView r2;
    ImageView r3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_my_books, container, false);
        handleImage(rootView,wtr1,  R.id.iv_my_books_wtr1);
        handleImage(rootView,wtr2,  R.id.iv_my_books_wtr2);
        handleImage(rootView,wtr3,  R.id.iv_my_books_wtr3);
        handleImage(rootView,cr1,  R.id.iv_my_books_cr1);
        handleImage(rootView,cr2,  R.id.iv_my_books_cr2);
        handleImage(rootView,cr3,  R.id.iv_my_books_cr3);
        handleImage(rootView,r1,  R.id.iv_my_books_r1);
        handleImage(rootView,r2,  R.id.iv_my_books_r2);
        handleImage(rootView,r3,  R.id.iv_my_books_r3);
        // Inflate the layout for this fragment
        return rootView;
    }

    private void handleImage(View view, ImageView imageView, int id){
        imageView = view.findViewById(id);
        imageView.setClipToOutline(true);
    }
}