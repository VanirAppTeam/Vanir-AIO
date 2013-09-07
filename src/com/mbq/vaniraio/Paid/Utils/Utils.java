package com.mbq.vaniraio.Paid.Utils;

import com.mbq.vaniraio.Paid.R;

import android.app.Activity;
import android.content.Intent;

public class Utils {
	private static int mTheme;
	
	public final static int Holo_Light = 0;	
	public final static int Holo = 1;
	public final static int Holo_Light_DAB = 2;
	public final static int Blue_AB = 3;
	public final static int INVERTED = 4;
	public final static int RED = 5;
	public final static int LIGHT = 6;
	
	public static void changeToTheme(Activity activity, int theme) {
		mTheme = theme;
		activity.finish();
		
		activity.startActivity(new Intent(activity, activity.getClass()));
	}
	
	public static void onActivityCreateSetTheme(Activity activity) {
		
		switch (mTheme) {
		default:
			activity.setTheme(R.style.Holo);
			break;
			
		case Holo_Light:
			activity.setTheme(R.style.Holo_Light);
			break;
			
		case Holo_Light_DAB:
			activity.setTheme(R.style.Holo_Light_DAB);
			break;
			
		case Blue_AB:
			activity.setTheme(R.style.blue_AB);
			break;
			
		case INVERTED:
			activity.setTheme(R.style.inverted);
			break;	
			
		case RED:
			activity.setTheme(R.style.red);
			break;		
			
		case LIGHT:
			activity.setTheme(R.style.light);
			break;			
		}
	}	
}
