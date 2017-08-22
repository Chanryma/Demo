package com.chanryma.webdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private Button button;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWebView();
        button = (Button) findViewById(R.id.btnClick);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callJSFunction();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setupWebView() {
        webView = (WebView) findViewById(R.id.webView);
        WebView.setWebContentsDebuggingEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "callbackHandler");
        webView.loadUrl("file:///android_asset/index.html?dev=android");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void callJSFunction() {
        webView.evaluateJavascript("showNativeMessage('Ma Qianli')", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                if ((value != null) && (!"null".equals(value))) {
                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
