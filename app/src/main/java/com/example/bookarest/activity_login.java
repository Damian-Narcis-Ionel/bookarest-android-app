package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class activity_login extends AppCompatActivity {

    TextView tv_not_a_member;
    ActivitySignup actSignup;
    Button switchToHome;
    activity_home actHome;


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
                switchActivities(actHome);
            }
        });
        
    }

    private void initialization(){
        tv_not_a_member=findViewById(R.id.tv_not_a_member);
        actSignup = new ActivitySignup();
        switchToHome = findViewById(R.id.button_login_login);
        actHome= new activity_home();

    }

    private void switchActivities(AppCompatActivity activity){

        Intent switchActivityIntent = new Intent(this,activity.getClass());
        startActivity(switchActivityIntent);

    }
}