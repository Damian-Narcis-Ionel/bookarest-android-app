package com.example.bookarest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class activity_home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadFragment(new fragment_home());

        BottomNavigationView navigation = findViewById(R.id.nav_home);
        navigation.setOnNavigationItemSelectedListener(this);

    }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
            return true;
        }
        return  false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_item_home:
                fragment = new fragment_home();
            break;
            case R.id.menu_item_my_books:
            fragment = new fragment_my_books();
            break;

            case R.id.menu_item_profile:
                fragment = new fragment_profile();
                break;

            case R.id.menu_item_settings:
                fragment = new fragment_settings();
                break;

        }

        return loadFragment(fragment);
    }
}