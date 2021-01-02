package com.example.bookarest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class fragment_profile extends Fragment {

    ImageView profilePicture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        handleImage(rootView,profilePicture,R.id.profile_picture);

        return rootView;


    }



    private void handleImage(View view, ImageView imageView, int id){
        imageView = view.findViewById(id);
        imageView.setClipToOutline(true);
    }
}