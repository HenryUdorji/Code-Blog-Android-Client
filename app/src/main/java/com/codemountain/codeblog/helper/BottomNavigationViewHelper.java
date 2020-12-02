package com.codemountain.codeblog.helper;

import android.content.Context;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentTransaction;

import com.codemountain.codeblog.R;
import com.codemountain.codeblog.activity.MainActivity;
import com.codemountain.codeblog.fragment.CreatePostFragment;
import com.codemountain.codeblog.fragment.HomeFragment;
import com.codemountain.codeblog.fragment.ProfileFragment;
import com.codemountain.codeblog.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationViewHelper {

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(item -> {
            FragmentTransaction transaction = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
            ActionBar supportActionBar = ((MainActivity) context).getSupportActionBar();
            switch (item.getItemId()){
                case R.id.home:
                    supportActionBar.setTitle("Home");
                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.container, homeFragment, "HOME");
                    transaction.commit();
                    return true;

                case R.id.createPost:
                    supportActionBar.setTitle("Create Post");
                    CreatePostFragment createPostFragment = new CreatePostFragment();
                    transaction.replace(R.id.container, createPostFragment, "CREATE_POST");
                    transaction.commit();
                    return true;

                case R.id.userProfile:
                    supportActionBar.setTitle("Profile");
                    ProfileFragment profileFragment = new ProfileFragment();
                    transaction.replace(R.id.container, profileFragment, "PROFILE");
                    transaction.commit();
                    return true;

                case R.id.searchPost:
                    supportActionBar.setTitle("Search");
                    SearchFragment searchFragment = new SearchFragment();
                    transaction.replace(R.id.container, searchFragment, "SEARCH");
                    transaction.commit();
                    return true;

            }
            return false;
        });
    }
}
