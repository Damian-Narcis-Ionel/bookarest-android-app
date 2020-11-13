package com.example.bookarest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class activity_home extends AppCompatActivity {

    //NavigationView menu = findViewById(R.id.nav_home);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


//        menu.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//                switch(item.getItemId()){
//                    case R.id.menu_item_home:
//                        break;
//                    case R.id.menu_item_my_books:
//                            break;
//                    case R.id.menu_item_profile:
//                        break;
//                    case R.id.menu_item_settings:
//                        break;
//                }
//            }
//        });
    }




}