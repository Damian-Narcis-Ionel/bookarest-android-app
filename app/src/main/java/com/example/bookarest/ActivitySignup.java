package com.example.bookarest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ActivitySignup extends AppCompatActivity {

    TextView tv_already_a_member;
    activity_login actLogin;

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
    }


    void initialization(){
        tv_already_a_member=findViewById(R.id.tv_already_a_member);
        actLogin = new activity_login();
    }

    private void switchActivity(AppCompatActivity activity){
        Intent switchActivityIntent = new Intent(this,activity.getClass());
        startActivity(switchActivityIntent);
        //overridePendingTransition(R.anim.slide_out_right,R.anim.slide_in_left);

    }

}