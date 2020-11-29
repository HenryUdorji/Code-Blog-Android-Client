package com.codemountain.codeblog.helper;

import android.content.Context;
import android.content.Intent;

import com.codemountain.codeblog.utils.SharedPref;

import static com.codemountain.codeblog.utils.Constants.AUTH_TOKEN;
import static com.codemountain.codeblog.utils.Constants.EMAIL;
import static com.codemountain.codeblog.utils.Constants.EXPIRES_AT;
import static com.codemountain.codeblog.utils.Constants.IS_LOGGED_IN;
import static com.codemountain.codeblog.utils.Constants.REFRESH_TOKEN;


public class UserManager {

    private static UserManager INSTANCE;

    public static UserManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserManager();
        }
        return INSTANCE;
    }

    /**
     * Create login session
     * */
    public void saveAuthResponseInPref(String authToken, String refreshToken, String email, Long expiresAt){
        //save authorization credentials
        SharedPref.getSharedPrefInstance().putBooleanInPref(IS_LOGGED_IN, true);
        SharedPref.getSharedPrefInstance().putStringInPref(AUTH_TOKEN, authToken);
        SharedPref.getSharedPrefInstance().putStringInPref(REFRESH_TOKEN, refreshToken);
        SharedPref.getSharedPrefInstance().putStringInPref(EMAIL, email);
        SharedPref.getSharedPrefInstance().putLongInPref(EXPIRES_AT, expiresAt);
    }

    /**
     * Check login method will check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
   /* public void checkLogin(Context context){
        // Check login status
        if(!SharedPref.getSharedPrefInstance().getIsLoggedIn()){
            // user is not logged in redirect user to Login Activity
            context.startActivity(new Intent(context, LoginActivity.class)
                    // Closing all the Activities
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    // Add new Flag to start new Activity
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }*/


    /**
     * Clear session details
     * */
   /* public void logoutUser(Context context){
        // Clearing all data from Shared Preferences
        SharedPref.getSharedPrefInstance().putBooleanInPref(IS_LOGGED_IN, false);
        SharedPref.getSharedPrefInstance().putStringInPref(AUTH_TOKEN, "");
        SharedPref.getSharedPrefInstance().putStringInPref(REFRESH_TOKEN, "");
        SharedPref.getSharedPrefInstance().putStringInPref(EMAIL, "");
        SharedPref.getSharedPrefInstance().putLongInPref(EXPIRES_AT, 0);
        // After logout redirect user to Login Activity
        context.startActivity(new Intent(context, LoginActivity.class)
                // Closing all the Activities
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                // Add new Flag to start new Activity
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

    }*/



}
