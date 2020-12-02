package com.codemountain.codeblog.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codemountain.codeblog.R;
import com.codemountain.codeblog.adapters.MainAdapter;
import com.codemountain.codeblog.dto.PostDto;
import com.codemountain.codeblog.fragment.HomeFragment;
import com.codemountain.codeblog.helper.BottomNavigationViewHelper;
import com.codemountain.codeblog.retrofit.ApiInterface;
import com.codemountain.codeblog.retrofit.ServiceGenerator;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navigation view
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        BottomNavigationViewHelper.enableNavigation(MainActivity.this, bottomNavigationView);

        //Default fragment
        getSupportActionBar().setTitle("Home");
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, homeFragment, "HOME");
        transaction.commit();
    }
}