package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class activity_login extends AppCompatActivity {

    TextView tv_not_a_member;
    ActivitySignup actSignup;
    Button switchToHome;
    activity_home actHome;
    private CurrentUser currentUser;
    EditText et_login_email, et_login_password;
    AppDb database = MainActivity.database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login);

        initialization();
        tv_not_a_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivities(actSignup);
                finish();
            }
        });



        switchToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validateLogin() != null){
                    getCurrentUserData(validateLogin());
                    switchActivities(actHome);
                }

            }
        });

        List<Book> books = database.bookDAO().getAllBooks();
        List<Author> authors = database.authorDAO().getAllAuthors();
        List<AuthorWithBooks> authorWithBooks = database.authorDAO().getAuthorsWithBooks();
        List<UserBookCrossRef> cross = database.UserBookCrossRefDAO().getAllUserBookCrossRefByIdAndCategory(1,2);
        
    }

    private void
    initialization(){

        et_login_email = findViewById(R.id.et_login_email);
        et_login_password= findViewById(R.id.et_login_password);
        tv_not_a_member=findViewById(R.id.tv_not_a_member);
        actSignup = new ActivitySignup();
        switchToHome = findViewById(R.id.button_login_login);
        actHome= new activity_home();

        insert();


    }

    private void switchActivities(AppCompatActivity activity){

        Intent switchActivityIntent = new Intent(this,activity.getClass());
        switchActivityIntent.putExtra("currentUser", currentUser);
        startActivity(switchActivityIntent);

    }

    private void insert(){
        database.authorDAO().insertAuthor(new Author(1, "damian"));
        database.authorDAO().insertAuthor(new Author(2, "Rares"));
        database.bookDAO().insertBook(new Book(1, "carte1", 1, 12));
        database.bookDAO().insertBook(new Book(2, "carte2", 1, 124));
        database.bookDAO().insertBook(new Book(3, "carte3", 1, 125));
        database.bookDAO().insertBook(new Book(4, "carte4", 2, 122));
        database.bookDAO().insertBook(new Book(5, "carte5", 2, 121));

        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(0,1,3));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(0,2,2));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(0,3,2));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(0,4,1));
        database.UserBookCrossRefDAO().insertUserBookCrossRef(new UserBookCrossRef(0,5,1));

        //database.userDAO().insertUser(new User(1, "dami007smecheru", "suntsmecher", "Narcis", "Damian", "123aloalo", 1, "23/06/1999", "Romania"));
        //database.userDAO().insertUser(new User(2, "rare007smecheru", "suntraressmecher", "Rares", "David", "1234aloalo", 2, "23/05/2020", "Romania"));

        database.userDAO().insertUser(new User(0, "admin@gmail.com", "admin", "ADMIN", "ADMIN", "072ADMIN", 1, "01/01/2020", "Romania"));
    }

    private void getCurrentUserData(String email){ // 1-wtr, 2-cr 3-r
        User user = database.userDAO().getUserByEmail(email);
        List<Integer> wtrId = database.UserBookCrossRefDAO().getAllUserBooksIdRefByIdAndCategory(user.getUserId(),1);
        List<Integer> crId = database.UserBookCrossRefDAO().getAllUserBooksIdRefByIdAndCategory(user.getUserId(),2);
        List<Integer> rId = database.UserBookCrossRefDAO().getAllUserBooksIdRefByIdAndCategory(user.getUserId(),3);

        List<Book> wtrBooks = new ArrayList<Book>();
        List<Book> crBooks = new ArrayList<Book>();
        List<Book> rBooks = new ArrayList<Book>();

        for(Integer i : wtrId){
            Book newWtrBook = database.bookDAO().getBookById(i);
            wtrBooks.add(newWtrBook);
        }

        for(Integer i : crId){
            Book newCrBook = database.bookDAO().getBookById(i);
            crBooks.add(newCrBook);
        }

        for(Integer i : rId){
            Book newRBook = database.bookDAO().getBookById(i);
            rBooks.add(newRBook);
        }
        currentUser = new CurrentUser(user,wtrBooks,crBooks,rBooks);
    }

    private String validateLogin(){



        if(TextUtils.isEmpty(et_login_email.getText().toString())){
            Toast.makeText(this,"Email field cannot be empty",Toast.LENGTH_LONG).show();
            return null;
        }

        if(TextUtils.isEmpty(et_login_password.getText().toString())){
            Toast.makeText(this,"Password field cannot be empty",Toast.LENGTH_LONG).show();
            return null;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(et_login_email.getText().toString()).matches()){
            Toast.makeText(this,"Invalid Email format",Toast.LENGTH_LONG).show();
            return null;
        }

        if(database.userDAO().getMatchingUser(et_login_email.getText().toString(),et_login_password.getText().toString()) == 0){
            Toast.makeText(this,"Incorrect email and/or password",Toast.LENGTH_LONG).show();
            return null;
        }

        return et_login_email.getText().toString();

    }
}