package com.codemountain.codeblog.utils;

import android.content.SharedPreferences;

import com.codemountain.codeblog.CodeBlogApp;

import static com.codemountain.codeblog.utils.Constants.AUTH_TOKEN;
import static com.codemountain.codeblog.utils.Constants.EMAIL;
import static com.codemountain.codeblog.utils.Constants.EXPIRES_AT;
import static com.codemountain.codeblog.utils.Constants.IS_LOGGED_IN;
import static com.codemountain.codeblog.utils.Constants.REFRESH_TOKEN;


public class SharedPref {
    private static SharedPref instance;

    public SharedPref() {
    }

    public static SharedPref init() {
        if (instance == null){
            instance = new SharedPref();
        }
        return instance;
    }

    public static SharedPref getSharedPrefInstance() {
        return instance;
    }

    public void putStringInPref(String key, String value) {
        SharedPreferences.Editor editor = CodeBlogApp.getSharedPref().edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putIntInPref(String key, int value) {
        SharedPreferences.Editor editor = CodeBlogApp.getSharedPref().edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putBooleanInPref(String key, boolean value) {
        SharedPreferences.Editor editor = CodeBlogApp.getSharedPref().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void putLongInPref(String key, long value) {
        SharedPreferences.Editor editor = CodeBlogApp.getSharedPref().edit();
        editor.putLong(key, value);
        editor.apply();
    }

    //Get authentication token
    public String getAuthToken() {
        return  CodeBlogApp.getSharedPref().getString(AUTH_TOKEN, "");
    }

    //Get refresh token for authentication
    public String getRefreshToken() {
        return  CodeBlogApp.getSharedPref().getString(REFRESH_TOKEN, "");
    }

    //Get refresh token for authentication
    public String getUserEmail() {
        return  CodeBlogApp.getSharedPref().getString(EMAIL, "");
    }

    public Long getExpiresAt() {
        return  CodeBlogApp.getSharedPref().getLong(EXPIRES_AT, 0);
    }


    // Get Login State
    public boolean getIsLoggedIn(){
        return CodeBlogApp.getSharedPref().getBoolean(IS_LOGGED_IN, false);
    }

}
