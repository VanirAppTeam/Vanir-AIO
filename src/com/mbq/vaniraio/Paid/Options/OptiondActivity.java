package com.mbq.vaniraio.Paid.Options;

import android.app.Activity;
import android.os.Bundle;

public class OptiondActivity extends Activity {
	
	// Im only here to open the Options menu, lulz
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new Options())
                .commit();
    }
}
