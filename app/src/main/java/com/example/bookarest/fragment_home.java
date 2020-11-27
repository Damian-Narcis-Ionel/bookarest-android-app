package com.example.bookarest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class fragment_home extends Fragment {

    ImageView img;
    Button btn_update_progress;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        handleImage(v,img,R.id.img_home_currently_reading);

        initialization(v);
        btn_update_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(100);
            }
        });


        return v;
    }


    private void handleImage(View view, ImageView imageView, int id){
        imageView = view.findViewById(id);
        imageView.setClipToOutline(true);
    }

    private void initialization(View view) {
        btn_update_progress = view.findViewById(R.id.button_home_update_progress);
        progressBar = view.findViewById(R.id.progress_home);
    }

    private void showAlert(int totalPages){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogStyle);
        builder.setTitle(R.string.button_home_update_progress);
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                progressBar.setProgress(Integer.parseInt(input.getText().toString()));
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}