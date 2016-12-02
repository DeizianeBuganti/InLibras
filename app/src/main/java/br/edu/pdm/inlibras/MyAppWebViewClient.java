package br.edu.pdm.inlibras;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Deizi on 01/12/2016.
 */
public class MyAppWebViewClient extends WebViewClient {

    // sobrescrevendo o método para load de url do componente webView
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
