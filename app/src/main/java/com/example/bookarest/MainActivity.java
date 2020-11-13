package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button switchToLogin;
    Button switchToSignup;
    activity_login actLogin;
    ActivitySignup actSignUp;
    TextView tv_terms_of_service;

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
    }

    private void initialization() {
        switchToLogin = findViewById(R.id.button_login);
        switchToSignup = findViewById(R.id.button_signup);
        actLogin= new activity_login();
        actSignUp=new ActivitySignup();
        tv_terms_of_service=findViewById(R.id.tv_terms_of_service);
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
}