package com.chanryma.webdemo;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by jonathanma on 21/8/2017.
 */

public class WebAppInterface {
    private Context mContext;

    WebAppInterface(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public void handleJSMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public String getData() {
        return "This message is created with native code, and shown in web view.";
    }
}