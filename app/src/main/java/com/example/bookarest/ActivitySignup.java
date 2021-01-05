package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivitySignup extends AppCompatActivity {

    TextView tv_already_a_member;
    activity_login actLogin;
    EditText et_signup_fname, et_signup_lname,et_signup_email,et_signup_password;
    Button btn_signup;
    MainActivity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);
        initialization();

        tv_already_a_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivity(actLogin);
                finish();

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(createUser() != null){
                    MainActivity.database.userDAO().insertUser(createUser());
                    switchActivity(mainActivity);
                    finish();
                    Toast.makeText(v.getContext(),"Account successfully created",Toast.LENGTH_LONG).show();

                }
            }
        });

    }


    void initialization(){
        tv_already_a_member=findViewById(R.id.tv_already_a_member);
        actLogin = new activity_login();
        et_signup_email = findViewById(R.id.et_signup_email);
        et_signup_fname = findViewById(R.id.et_signup_firstname);
        et_signup_lname = findViewById(R.id.et_signup_lastname);
        et_signup_password = findViewById(R.id.et_signup_password);
        btn_signup = findViewById(R.id.button_signup_signup);
        mainActivity = new MainActivity();

    }

    private void switchActivity(AppCompatActivity activity){
        Intent switchActivityIntent = new Intent(this,activity.getClass());
        startActivity(switchActivityIntent);


    }

    private User createUser() {
        if(TextUtils.isEmpty(et_signup_fname.getText().toString())){
            Toast.makeText(this, "First name field cannot be empty!", Toast.LENGTH_LONG).show();
            return null;
        }
        if(TextUtils.isEmpty(et_signup_lname.getText().toString())){
            Toast.makeText(this, "Last name field cannot be empty!", Toast.LENGTH_LONG).show();
            return null;
        }
        if(TextUtils.isEmpty(et_signup_email.getText().toString())){
            Toast.makeText(this, "Email field cannot be empty!", Toast.LENGTH_LONG).show();
            return null;
        }
        if(TextUtils.isEmpty(et_signup_password.getText().toString())){
            Toast.makeText(this, "Password field cannot be empty!", Toast.LENGTH_LONG).show();
            return null;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(et_signup_email.getText().toString()).matches()){
            Toast.makeText(this, "Invalid email format!", Toast.LENGTH_LONG).show();
            return null;
        }
        if(MainActivity.database.userDAO().checkExistingEmail(et_signup_email.getText().toString())>0){
            Toast.makeText(this, "Email address already exists!", Toast.LENGTH_LONG).show();
            return null;
        }

        int maxId = MainActivity.database.userDAO().getMaxUserId();
        return new User(maxId+1,
                et_signup_email.getText().toString(),
                et_signup_password.getText().toString(),
                et_signup_fname.getText().toString(),
                et_signup_lname.getText().toString(),
                "N/A",
                0,
                "N/A",
                "N/A");
    }

}