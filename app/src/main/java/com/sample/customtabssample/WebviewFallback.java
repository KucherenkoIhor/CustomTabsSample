package com.sample.customtabssample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * A Fallback that opens a Webview when Custom Tabs is not available
 */
public class WebviewFallback implements CustomTabActivityHelper.CustomTabFallback {

    @Override
    public void openUri(Activity activity, String url) {
        Intent intent = new Intent(activity, WebviewActivity.class);
        intent.putExtra(WebviewActivity.EXTRA_URL, url);
        activity.startActivity(intent);
    }
}