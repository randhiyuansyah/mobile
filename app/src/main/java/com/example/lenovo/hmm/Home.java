package com.example.lenovo.hmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private BottomNavigationView navigation;
    private FrameLayout homeFrame;

    private HomeFragment homeFragment;
    private AkunFragment akunFragment;
    private CheckUpFragment checkUpFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigation = findViewById(R.id.navigation);
        homeFrame = findViewById(R.id.homeFrame);



        homeFragment = new HomeFragment();
        akunFragment = new AkunFragment();
        checkUpFragment = new CheckUpFragment();

        navigation.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.homeFrame, new HomeFragment()).commit();


      }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected_fragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selected_fragment = new HomeFragment();
                            break;
                        case R.id.navigation_check_up:
                            selected_fragment = new CheckUpFragment();
                            break;
                        case R.id.navigation_akun:
                            selected_fragment = new AkunFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeFrame, selected_fragment).commit();

                    return true;
                }
            };
    }
