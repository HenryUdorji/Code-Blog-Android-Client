package com.codemountain.codeblog.helper;

import android.content.Context;

import com.codemountain.codeblog.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;


public class BottomNavigationViewHelper {

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

                case R.id.createPost:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

                case R.id.bookmarkPost:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

                case R.id.searchPost:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

            }
            return false;
        });
    }

    /*
    * //Default fragment
        getSupportActionBar().setTitle("Business News");
        BusinessNewsFragment businessNewsFragment = new BusinessNewsFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, businessNewsFragment, "BUSINESS_NEWS_FRAGMENT");
        transaction.commit();*/
}
