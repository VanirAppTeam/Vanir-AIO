package com.mbq.vaniraio.Paid.Social.Mobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mbq.vaniraio.Paid.R;

public class MobileFacebook extends Activity {
	Context context;
	WebView FBwv;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        
        requestWindowFeature(Window.FEATURE_PROGRESS);
        
        setContentView(R.layout.desktop_facebook);
        
		WebView MobileFacebookWV = (WebView) findViewById(R.id.DesktopFacebookWV);
		
		MobileFacebookWV.loadUrl("https://www.facebook.com/MBQsniper/");
		
		MobileFacebookWV.clearCache(true);
		
		MobileFacebookWV.getSettings().setJavaScriptEnabled(true);        

		MobileFacebookWV.getSettings().setBuiltInZoomControls(true);
	    
		MobileFacebookWV.setWebChromeClient(new WebChromeClient());
		
		MobileFacebookWV.setDownloadListener(new DownloadListener() {
	    	
	      @Override
	      public void onDownloadStart(String url, String userAgent,
	              String contentDisposition, String mimetype,
	              long contentLength) {

	          Uri uri = Uri.parse(url);
	          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	          startActivity(intent);
	      }
	  });
	    
		MobileFacebookWV.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });
		
        MobileFacebookWV.setWebViewClient(new WebViewClient() {

	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         {
	        	 view.loadUrl(url);
	            return true;
	        }
	    }});
	}
}