package com.chanryma.fetchtopactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void onButtonClick(View view) {
//        Intent intent = new Intent(MyApplication.getInstance().getApplicationContext(), ActivityC.class);
//        MyApplication.getInstance().getCurrentActivity().startActivity(intent);

        Intent intent = new Intent(ActivityB.this, ActivityC.class);
        startActivity(intent);
    }
}
