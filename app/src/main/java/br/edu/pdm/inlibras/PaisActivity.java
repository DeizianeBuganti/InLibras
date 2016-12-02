package br.edu.pdm.inlibras;


/*
*
* Tela de ambiente para os Pais Ouvintes do app InLibras
*
* */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import br.edu.pdm.inlibras.R;

public class PaisActivity extends AppCompatActivity {
    // declara uma variável webView
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);
        // amarra a variável com o componente webView
        mWebView = (WebView) findViewById(R.id.webViewP);
        // seta as settings do componente
        WebSettings webSettings = mWebView.getSettings();
        // habilitado o JavaScript, por se tratar de uma página web
        webSettings.setJavaScriptEnabled(true);
        // define a url que será carregada no componente
        mWebView.loadUrl("http://inlibras.com.br/AndroidPais");
        // e seta o cliente webView, para que o load personalizado abra no componente do app
        mWebView.setWebViewClient(new MyAppWebViewClient());
    }
}
