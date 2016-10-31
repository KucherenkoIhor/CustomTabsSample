package com.sample.customtabssample;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String SAMPLE_URL = "https://developer.chrome.com/multidevice/android/customtabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.linkTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int primaryColor = ContextCompat.getColor(
                        MainActivity.this,
                        R.color.colorPrimary);
                CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder()
                        .setToolbarColor(primaryColor)
                        .setStartAnimations(MainActivity.this, R.anim.slide_in_right, R.anim.slide_out_left)
                        .setExitAnimations(MainActivity.this, R.anim.slide_in_left, R.anim.slide_out_right)
                        .build();
                CustomTabActivityHelper.openCustomTab(
                        MainActivity.this, customTabsIntent, SAMPLE_URL, new WebviewFallback());
            }
        });
    }
}
