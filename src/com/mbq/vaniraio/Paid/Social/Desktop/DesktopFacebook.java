package com.mbq.vaniraio.Paid.Social.Desktop;

import com.mbq.vaniraio.Paid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DesktopFacebook extends Activity {
	Context context;
	WebView DesktopFacebookWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main_vanir);
		
		DesktopFacebookWV.getSettings().setUserAgentString("Mozilla/5.0 " +
				"(Windows NT 6.2; " +
				"WOW64) AppleWebKit/537.31 " +
				"(KHTML, like Gecko) Chrome/20 " +
				"Safari/537.31");
		
		DesktopFacebookWV.loadUrl("https://www.facebook.com/MBQsniper/");
		
		DesktopFacebookWV.clearCache(true);
		
		DesktopFacebookWV.getSettings().setJavaScriptEnabled(true);        

		DesktopFacebookWV.getSettings().setBuiltInZoomControls(true);
	    
		DesktopFacebookWV.setWebChromeClient(new WebChromeClient());
		
		DesktopFacebookWV.setDownloadListener(new DownloadListener() {
	    	
	      @Override
	      public void onDownloadStart(String url, String userAgent,
	              String contentDisposition, String mimetype,
	              long contentLength) {

	          Uri uri = Uri.parse(url);
	          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	          startActivity(intent);
	      }
	  });
	    
		DesktopFacebookWV.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
            }
        });
		
		DesktopFacebookWV.setWebViewClient(new WebViewClient() {

	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         {
	        	 view.loadUrl(url);
	            return true;
	        }
	    }
	        }
		);
	}
}
