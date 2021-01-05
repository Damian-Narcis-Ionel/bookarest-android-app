package com.example.bookarest;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;


public class fragment_home extends Fragment {

    ImageView img;
    Button btn_update_progress;
    ProgressBar progressBar;
    TextView tv_percentage;
    TextView tv_bookTitle;
    TextView tv_author;
    CurrentUser currentUser;
    Book currentlyReadingBook;
    AppDb database;

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
                showAlert(currentlyReadingBook.getNumberOfPages(), currentlyReadingBook.getTitle());
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
        tv_percentage = view.findViewById(R.id.tv_home_progress_percentage);
        tv_bookTitle = view.findViewById(R.id.tv_home_cr_title);
        tv_author = view.findViewById(R.id.tv_home_cr_author);
        activity_home act = (activity_home)getActivity();
        currentUser = act.currentUser;

        database = MainActivity.database;
        updateHomeFragment();
        

    }


    @SuppressLint({"ResourceAsColor", "NewApi"})
    private void showAlert(final int totalPages, String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),R.style.DialogStyle);
        builder.setTitle(R.string.button_home_update_progress);
        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setTextCursorDrawable(null);
        input.setBackgroundTintList(ColorStateList.valueOf(R.color.colorFirstActivityButtons));
        input.setHint("Enter number of pages read");
        builder.setMessage(title + " has " + totalPages + " pages.");
        builder.setView(input);


        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                progressBar.setProgress(Integer.parseInt(input.getText().toString())*100/totalPages);
                tv_percentage.setText(progressBar.getProgress() + "%");

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dlg = builder.create();
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dlg.show();
    }

    private Book returnCurrentlyReadingBook(){
        Random random = new Random();
        return currentUser.getCurrentlyReading().get(random.nextInt(currentUser.getCurrentlyReading().size()));
    }

    private void setCurrentlyReadingText(){

        tv_bookTitle.setText(currentlyReadingBook.getTitle());
        tv_author.setText(database.authorDAO().getAuthorNameById(currentlyReadingBook.getAuthorOfBookId()));

    }
    
    private void updateHomeFragment(){
        if(currentUser.getCurrentlyReading().size()>0){
            currentlyReadingBook=returnCurrentlyReadingBook();
            setCurrentlyReadingText();
        }else{
            tv_bookTitle.setText("Not reading anything right now..");
            tv_author.setText("Go find a book you like!");
            btn_update_progress.setEnabled(false);

        }
    }
}