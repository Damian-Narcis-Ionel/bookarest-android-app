package com.example.bookarest;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class fragment_home extends Fragment {

    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        handleImage(v,img,R.id.img_home_currently_reading);

        return v;
    }


    private void handleImage(View view, ImageView imageView, int id){
        imageView = view.findViewById(id);
        imageView.setClipToOutline(true);
    }
}