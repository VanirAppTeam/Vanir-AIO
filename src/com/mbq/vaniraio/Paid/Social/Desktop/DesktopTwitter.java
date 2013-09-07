package com.mbq.vaniraio.Paid.Social.Desktop;

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

public class DesktopTwitter extends Activity {
	Intent i;
	Context context;
	WebView DesktopTwitterWV;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        
        requestWindowFeature(Window.FEATURE_PROGRESS);
        
        setContentView(R.layout.desktop_twitter);
        
		WebView DesktopTwitterWV = (WebView) findViewById(R.id.desktoptwitterWV);
		
		DesktopTwitterWV.getSettings().setUserAgentString("Mozilla/5.0 " +
				"(Windows NT 6.2; " +
				"WOW64) AppleWebKit/537.31 " +
				"(KHTML, like Gecko) Chrome/20 " +
				"Safari/537.31");
		
		DesktopTwitterWV.loadUrl("http://www.MBQonXDA.net/Vanir/");
		
		DesktopTwitterWV.clearCache(true);
		
		DesktopTwitterWV.getSettings().setJavaScriptEnabled(true);        

		DesktopTwitterWV.getSettings().setBuiltInZoomControls(true);
	    
		DesktopTwitterWV.setWebChromeClient(new WebChromeClient());
		
		DesktopTwitterWV.setDownloadListener(new DownloadListener() {
	    	
	      @Override
	      public void onDownloadStart(String url, String userAgent,
	              String contentDisposition, String mimetype,
	              long contentLength) {

	          Uri uri = Uri.parse(url);
	          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	          startActivity(intent);
	      }
	  });
	    
		DesktopTwitterWV.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
            }
        });
		
		DesktopTwitterWV.setWebViewClient(new WebViewClient() {

	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         {
	        	 view.loadUrl(url);
	            return true;
	        }
	    }});
	}
}
