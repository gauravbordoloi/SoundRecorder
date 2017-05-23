package com.gmonetix.soundrecorder.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.gmonetix.soundrecorder.R;

/**
 * @author Gmonetix
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_pref);

        Preference prefTermAndPolicy = (Preference) findPreference(getResources().getString(R.string.pref_title_term));

        prefTermAndPolicy.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                dialogTerm(getActivity());
                return true;
            }
        });

    }

    public void dialogTerm(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(getResources().getString(R.string.pref_title_term));
        builder.setMessage(getResources().getString(R.string.terms_conditions));
        builder.setPositiveButton("OK", null);
        builder.show();
    }

}
