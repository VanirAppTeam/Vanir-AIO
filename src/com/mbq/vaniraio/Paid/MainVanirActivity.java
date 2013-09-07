package com.mbq.vaniraio.Paid;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import se.emilsjolander.flipview.FlipView;
import se.emilsjolander.flipview.OverFlipMode;
import se.emilsjolander.flipview.FlipView.OnFlipListener;
import se.emilsjolander.flipview.FlipView.OnOverFlipListener;

import com.mbq.vaniraio.Paid.Options.Options;
import com.mbq.vaniraio.Paid.Utils.Utils;

import de.cketti.library.changelog.ChangeLog;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

@SuppressWarnings("unused")
public class MainVanirActivity extends Activity {
	// Used later
	Intent intent;
	
	// MMMMMM TOAST
	Toast toast;
   	
	// Some fragments that get called
	Fragment Welcome = new com.mbq.vaniraio.Paid.Welcome.Welcome();
	Fragment Nightlies = new com.mbq.vaniraio.Paid.Fragments.Nightlies();
	Fragment Extras = new com.mbq.vaniraio.Paid.Fragments.Extras();
	Fragment GApps = new com.mbq.vaniraio.Paid.Fragments.GApps();
	
	// Options menu fragment
	Fragment Options = new Options();
	
    private DrawerLayout mDrawerLayout;
    
    private ListView mDrawerList;
    
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    
    private CharSequence mTitle;
    
	private String[] mCategories;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        // Call Utils.java to help set the theme onClick
        Utils.onActivityCreateSetTheme(this);
        
        setContentView(R.layout.activity_main_vanir);
        
        ChangeLog cl = new ChangeLog(this);
        if (cl.isFirstRun()) {
        	
            cl.getLogDialog().show(); 
            
        }             

        mTitle = mDrawerTitle = getTitle();
        
        mCategories = getResources().getStringArray(R.array.Sites);
        
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mCategories));
        
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
        		
                this,
                
                mDrawerLayout,
                
                R.drawable.ic_drawer,
                
                R.string.drawer_open,
                
                R.string.drawer_close
                
                ) 
        
        {
            public void onDrawerClosed(View view) {
            	
                getActionBar().setTitle(mTitle);
                
                invalidateOptionsMenu();
                
            }

            public void onDrawerOpened(View drawerView) {
            	
                getActionBar().setTitle(mDrawerTitle);
                
                invalidateOptionsMenu();
            }
        };
        
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
        	
            selectItem(0);
            
        }
    } 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        getMenuInflater().inflate(R.menu.main_vanir, menu);
        
        return true;
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
        
        case R.id.Holo_Light:
        	Utils.changeToTheme(this, Utils.Holo_Light);
        	
        	break;                
            
        case R.id.Holo:
        	Utils.changeToTheme(this, Utils.Holo);
        	Toast.makeText(this, R.string.holo_theme_set, Toast.LENGTH_LONG).show();
        	break;
        
        case R.id.Holo_Light_DAB:
        	Utils.changeToTheme(this, Utils.Holo_Light_DAB);
        	Toast.makeText(this, R.string.holo_light_dab_theme_set, Toast.LENGTH_LONG).show();
        	break;  
        	
        case R.id.blue_actionbar:
        	Utils.changeToTheme(this, Utils.Blue_AB);
        	Toast.makeText(this,  R.string.blue_ab_theme_set, Toast.LENGTH_LONG).show();
        	break;
        	
        case R.id.theme_inverted:
        	Utils.changeToTheme(this, Utils.INVERTED);
        	Toast.makeText(this,  R.string.inverted_theme_set, Toast.LENGTH_LONG).show();
        	break;   
        	
        case R.id.theme_red:
        	Utils.changeToTheme(this, Utils.RED);
        	Toast.makeText(this,  R.string.red_theme_set, Toast.LENGTH_LONG).show();
        	break;   
        	
        case R.id.light_theme:
        	Utils.changeToTheme(this, Utils.LIGHT);
        	Toast.makeText(this,  R.string.light_theme_set, Toast.LENGTH_LONG).show();
        	break;        	
        
        case R.id.menu_full_changelog:
            new ChangeLog(this).getFullLogDialog().show();
            break;
                
        case R.id.deuces:
        	Toast.makeText(this, R.string.on_exit, Toast.LENGTH_LONG).show();
            finish();
            super.finish();
            break;            	
            
         case R.id.version:
        	 
    		AlertDialog.Builder versionalert = new AlertDialog.Builder(this);
    			
    			versionalert.setMessage("Version 0.1.1");
    			
    			versionalert.setNeutralButton("OK",
    					
    					new DialogInterface.OnClickListener() {
    				
    						public void onClick(DialogInterface arg0, int arg1) {
    							
    						}
    					});
    			
    			versionalert.show();   
    			
    			break; 
    			
         case R.id.fb_desktop:
	        
        	 Toast.makeText(this, R.string.lazy, Toast.LENGTH_LONG).show();
        	 
        	 break;   
      	 
        	 
         case R.id.fb_mobile:

        	 Toast.makeText(this, R.string.lazy, Toast.LENGTH_LONG).show();
        	 
        	 break;     
        	 
         case R.id.twitter_desktop:

        	 Toast.makeText(this, R.string.lazy, Toast.LENGTH_LONG).show();
        	 
        	 break;   
        	 
         case R.id.twitter_mobile:

        	 Toast.makeText(this, R.string.lazy, Toast.LENGTH_LONG).show();
        	 
        	 break;   
        	 
         // Group        	 
         case R.id.hwa_toggle:
        	 
        	 // Useless for now
        	 
        	 break;
             
         	case R.id.hwa_true:
         		
         		Crouton.makeText(this, R.string.dummy_enabled, Style.CONFIRM).show();
     	 
         		break;
        	 
         	case R.id.hwa_false:
         		
         		Crouton.makeText(this, R.string.dummy_disabled, Style.ALERT).show();
        	 
         		break;
         		
         	case R.id.hwa_info:

         		
         		
         		break;

		case R.id.q:
        	 
             new AlertDialog.Builder(this)
             
             .setTitle("WAIT")
             
             .setMessage("You happy you bought this?")
             
             .setPositiveButton("Yes :D", new DialogInterface.OnClickListener() {
            	 
                 public void onClick(DialogInterface dialog, int which) { 
                 	
                 }
              })
              
             .setNegativeButton("No >:(", new DialogInterface.OnClickListener() {
            	 
                 public void onClick(DialogInterface dialog, int which) { 
                	 
                 }
              })
              .show(); 
             
             default:
	 
        };     

    return super.onOptionsItemSelected(item);
}  

private class DrawerItemClickListener implements ListView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }
}

private void selectItem(int position) {
	 
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    switch (position) {
    
    case 0:
    	// Let's only run the app once 
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		if(!prefs.getBoolean("firstTime", false)) {
			
			Crouton.makeText(this, R.string.thanks_bro, Style.INFO).show();
			
			Crouton.makeText(this, R.string.survey, Style.ALERT).show();
			
		    SharedPreferences.Editor editor = prefs.edit();
		    
		    editor.putBoolean("firstTime", true);
		    editor.commit();
		    
		}
		
        ft.replace(R.id.content_frame, Welcome);
        
        break;     
    
    case 1:
        ft.replace(R.id.content_frame, Nightlies);
        break;          
    
    case 2:
        ft.replace(R.id.content_frame, Extras);
        break;   
        
    case 3:
        ft.replace(R.id.content_frame, GApps);
        break;          
        
    case 4:
    	Crouton.makeText(this, R.string.not_ready_yet, Style.ALERT).show();
    	ft.replace(R.id.content_frame, Options);
    	break;	
        
    }
    
    ft.commit();
    
    mDrawerList.setItemChecked(position, true);

    mDrawerLayout.closeDrawer(mDrawerList);
}

@Override
public void setTitle(CharSequence title) {
    mTitle = title;
    getActionBar().setTitle(mTitle);
}

/**
 * When using the ActionBarDrawerToggle, you must call it during
 * onPostCreate() and onConfigurationChanged()...
 */

@Override
protected void onPostCreate(Bundle savedInstanceState) {
	
    super.onPostCreate(savedInstanceState);
    
    // Sync the toggle state after onRestoreInstanceState has occurred.
    mDrawerToggle.syncState();
}

@Override
public void onConfigurationChanged(Configuration newConfig) {
	
    super.onConfigurationChanged(newConfig);
    
    // Pass any configuration change to the drawer toggls
    mDrawerToggle.onConfigurationChanged(newConfig);
}

public static class CategoriesFragment extends Fragment {
	
public static final String ARG_CATEGORY = "category";

public CategoriesFragment() {

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
	
    View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
    
    int i = getArguments().getInt(ARG_CATEGORY);
    
    String planet = getResources().getStringArray(R.array.Sites)[i];
    
    getActivity().setTitle(planet);
    
    return rootView;
    
      }
   }
}