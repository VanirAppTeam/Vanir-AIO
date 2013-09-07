package com.mbq.vaniraio.Paid.Options;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.mbq.vaniraio.Paid.R;

public class Options extends PreferenceFragment {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.options);
    }
}