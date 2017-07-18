package com.chanryma.fetchtopactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityA extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        MyApplication.getInstance().setCurrentActivity(this);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(ActivityA.this, ActivityB.class);
        startActivity(intent);
    }
}
