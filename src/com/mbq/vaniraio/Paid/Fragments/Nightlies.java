package com.mbq.vaniraio.Paid.Fragments;

import com.mbq.vaniraio.Paid.R;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Nightlies extends Fragment {
	Context context;
	WebView wv;

	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	    final View view = inflater.inflate(R.layout.vanir_nightly_webview, container, false);
        
		WebView wv = (WebView) view.findViewById(R.id.wv1);
		
		wv.getSettings().setUserAgentString("Mozilla/5.0 " +
				"(Windows NT 6.2; " +
				"WOW64) AppleWebKit/537.31 " +
				"(KHTML, like Gecko) Chrome/20 " +
				"Safari/537.31");
		
		wv.loadUrl("http://mbqonxda.net/Vanir/");
		
		wv.clearCache(true);
		
	    WebSettings webSettings = wv.getSettings();
	    
        wv.getSettings().setJavaScriptEnabled(true);        

        wv.getSettings().setBuiltInZoomControls(true);
	    
	    wv.setWebChromeClient(new WebChromeClient());
		
	    wv.setDownloadListener(new DownloadListener() {
	    	
	      @Override
	      public void onDownloadStart(String url, String userAgent,
	              String contentDisposition, String mimetype,
	              long contentLength) {

	          Uri uri = Uri.parse(url);
	          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	          startActivity(intent);
	          
	      }
	  });
	    
        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
            }
        });
		
	    wv.setWebViewClient(new WebViewClient() {

	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         {
	        	 view.loadUrl(url);
	            return true;
	        }
	    }});
		return wv;
	}
}
