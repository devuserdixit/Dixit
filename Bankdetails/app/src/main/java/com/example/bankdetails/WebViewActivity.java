package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        view();
    }

    private void view() {
        WebView webView = findViewById(R.id.webview);

        String url = getIntent().getExtras().getString("url");

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient());
    }
}