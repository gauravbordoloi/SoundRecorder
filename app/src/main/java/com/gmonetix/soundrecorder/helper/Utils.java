package com.gmonetix.soundrecorder.helper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.gmonetix.soundrecorder.R;

/**
 * @author Gmonetix
 */

public class Utils {

    public static void setFont(Context _context, TextView textView) {
        Typeface roboto = Typeface.createFromAsset(_context.getAssets(), "font/RobotoLight.ttf");
        textView.setTypeface(roboto);
    }

    public static void applyFontForToolbarTitle(Activity context){
        Toolbar toolbar = (Toolbar) context.findViewById(R.id.toolbar);
        for(int i = 0; i < toolbar.getChildCount(); i++){
            View view = toolbar.getChildAt(i);
            if(view instanceof TextView){
                TextView tv = (TextView) view;
                if(tv.getText().equals(toolbar.getTitle())){
                    setFont(context,tv);
                    break;
                }
            }
        }
    }

    public static Intent openFacebook(Context context){
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/122591891284060"));
        } catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://facebook.com/gmonetix"));
        }
    }

    public static Intent openYoutube(Context context){
        try {
            context.getPackageManager().getPackageInfo("com.google.android.youtube",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCpfLFzQqRl01sXP7dxIQ_rg"));
        } catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCpfLFzQqRl01sXP7dxIQ_rg"));
        }
    }

    public static Intent openSite(Context context){
        try {
            return new Intent(context.getPackageManager().getLaunchIntentForPackage("com.gmonetix.gmonetix").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.gmonetix.com"));
        }
    }

    public static void rateApp(Activity activity) {
        Uri uri = Uri.parse("market://details?id=" + activity.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            activity.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + activity.getPackageName())));
        }
    }

}
