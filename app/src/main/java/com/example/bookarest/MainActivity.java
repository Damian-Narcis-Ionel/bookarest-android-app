package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button switchToLogin;
    Button switchToSignup;
    activity_login actLogin;
    ActivitySignup actSignUp;
    TextView tv_terms_of_service;
    private AppDb database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        initialization();
        switchToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities(actLogin);
            }
        });


        switchToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities(actSignUp);
            }
        });

        tv_terms_of_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(getString(R.string.terms_of_service_lorem),MainActivity.this);
            }
        });

        List<Book> books = database.bookDAO().getAllBooks();
        List<Author> authors = database.authorDAO().getAllAuthors();
        List<AuthorWithBooks> authorWithBooks = database.authorDAO().getAuthorsWithBooks();
        List<UserBookCrossRef> cross = database.UserBookCrossRefDAO().getAllUserBookCrossRefByIdAndCategory(1,2);


//        for(Book b : books){
//            Log.v("test",b.toString());
//        }
//
//        for(Author b : authors){
//            Log.v("test",b.toString());
//        }
//
//        for(AuthorWithBooks b : authorWithBooks){
//            Log.v("test",b.toString());
//        }

        for(UserBookCrossRef b : cross){
            Log.v("test",b.toString());
        }

    }

    private void initialization() {
        switchToLogin = findViewById(R.id.button_login);
        switchToSignup = findViewById(R.id.button_signup);
        actLogin = new activity_login();
        actSignUp = new ActivitySignup();
        tv_terms_of_service = findViewById(R.id.tv_terms_of_service);
        database = Room.databaseBuilder(this, AppDb.class, "test1").allowMainThreadQueries().build();
        insert();


        database.userDAO().insertUser(new User(1, "dami007smecheru", "suntsmecher", "Narcis", "Damian", "123aloalo", 1, "23/06/1999", "Romania"));
        database.userDAO().insertUser(new User(2, "rare007smecheru", "suntraressmecher", "Rares", "David", "1234aloalo", 2, "23/05/2020", "Romania"));


        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(1,3,1));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(1,2,2));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(1,1,3));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(2,3,1));



    }

    private void insert(){
        database.authorDAO().insertAuthor(new Author(1, "damian"));
        database.authorDAO().insertAuthor(new Author(2, "Rares"));
        database.bookDAO().insertBook(new Book(1, "carte1", 1, 12));
        database.bookDAO().insertBook(new Book(2, "carte2", 1, 124));
        database.bookDAO().insertBook(new Book(3, "carte3", 1, 125));
        database.bookDAO().insertBook(new Book(4, "carte4", 2, 122));
        database.bookDAO().insertBook(new Book(5, "carte5", 2, 121));
    }

    private void switchActivities(AppCompatActivity activity) {
        Intent switchActivityIntent = new Intent(this, activity.getClass());
        startActivity(switchActivityIntent);


    }


    private void showAlert(String message, Context con){
        AlertDialog.Builder dialog = new AlertDialog.Builder(con,R.style.DialogStyle);

        dialog.setMessage(message);
        dialog.setTitle(getString(R.string.dlg_terms_of_service_title));
        dialog.setPositiveButton(" OK ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dlg = dialog.create();
        dlg.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dlg.show();
        dlg.getWindow().setLayout(1000,1600);
    }

    private void insertAuthors(){

    }

}