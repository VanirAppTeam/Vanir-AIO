package com.mbq.vaniraio.Paid.Social.Mobile;

import com.mbq.vaniraio.Paid.R;

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

public class MobileTwitter extends Activity {
	Context context;
	WebView MobileTwitterWV;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        
        requestWindowFeature(Window.FEATURE_PROGRESS);
        
        setContentView(R.layout.desktop_facebook);
        
		WebView MobileTwitterWV = (WebView) findViewById(R.id.mobiletwitterWV);
		
		MobileTwitterWV.loadUrl("https://www.facebook.com/MBQsniper/");
		
		MobileTwitterWV.clearCache(true);
		
		MobileTwitterWV.getSettings().setJavaScriptEnabled(true);        

		MobileTwitterWV.getSettings().setBuiltInZoomControls(true);
	    
		MobileTwitterWV.setWebChromeClient(new WebChromeClient());
		
		MobileTwitterWV.setDownloadListener(new DownloadListener() {
	    	
	      @Override
	      public void onDownloadStart(String url, String userAgent,
	              String contentDisposition, String mimetype,
	              long contentLength) {

	          Uri uri = Uri.parse(url);
	          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	          startActivity(intent);
	      }
	  });
	    
		MobileTwitterWV.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });
		
		MobileTwitterWV.setWebViewClient(new WebViewClient() {

	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         {
	        	 view.loadUrl(url);
	            return true;
	        }
	    }});
	}
}
