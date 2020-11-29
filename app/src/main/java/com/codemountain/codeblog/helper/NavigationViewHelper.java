package com.codemountain.codeblog.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.codemountain.myblog.R;
import com.codemountain.myblog.view.activity.MainActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;


public class NavigationViewHelper {

    public static void enableNavigation(final Context context, final NavigationView view){
        view.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    Intent intent = new Intent(context, MainActivity.class);
                    context.startActivity(intent);
                    ((MainActivity)context).overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                    return true;

                case R.id.share:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

                case R.id.rate:
                    try{
                        Uri rateApp = Uri.parse("market://details?id=" + context.getPackageName());
                        Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, rateApp);
                        context.startActivity(rateAppIntent);
                    }
                    catch (ActivityNotFoundException e) {
                        Uri rateApp = Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName());
                        Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, rateApp);
                        context.startActivity(rateAppIntent);
                    }
                    return true;

                case R.id.appSettings:
                    Snackbar.make(view,"Feature coming soon!", Snackbar.LENGTH_LONG).show();
                    return true;

                case R.id.feedback:
                    final Intent feedBackIntent = new Intent(Intent.ACTION_SEND);
                    feedBackIntent.setType("message/rfc822");
                    feedBackIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{context.getString(R.string.feedback_email)});
                    feedBackIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.feedback_subject));
                    feedBackIntent.setPackage("com.google.android.gm");
                    context.startActivity(feedBackIntent);
                    return true;

            }
            return false;
        });
    }
}
