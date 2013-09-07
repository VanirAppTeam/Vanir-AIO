package com.mbq.vaniraio.Paid.Options;

import com.mbq.vaniraio.Paid.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CroutonPrefs extends PreferenceActivity {
	
	
	public void onToggleClicked(View view) {
		boolean on = ((ToggleButton) view).isChecked();
		
		if (on) {
			Crouton.makeText(this, R.string.im_alive, Style.INFO).show();
			
		} else {
			Toast.makeText(this, R.string.toasty, Toast.LENGTH_LONG).show();
		}
	}
}