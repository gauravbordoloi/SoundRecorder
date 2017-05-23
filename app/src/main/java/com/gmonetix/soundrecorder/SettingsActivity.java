package com.gmonetix.soundrecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gmonetix.soundrecorder.fragments.SettingsFragment;
import com.gmonetix.soundrecorder.helper.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SettingsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SettingsActivity.this.setTitle("Settings");
        Utils.applyFontForToolbarTitle(this);

        getFragmentManager().beginTransaction().replace(R.id.settingsFragment,new SettingsFragment()).commit();

        MobileAds.initialize(getApplicationContext(),getResources().getString(R.string.ad1_unit_id_SettingsActivity1));
        adView = (AdView) findViewById(R.id.adViewSettingsActivity);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(Device.getId(this)).build();
        adView.loadAd(adRequest);

    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

}
