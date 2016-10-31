package com.sample.customtabssample;

import android.app.Activity;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.util.Log;

/**
 * This is a helper class to manage the connection to the Custom Tabs Service.
 */
public class CustomTabActivityHelper {

    private static final String TAG = CustomTabActivityHelper.class.getSimpleName();

    public static void openCustomTab(Activity activity,
                                     CustomTabsIntent customTabsIntent,
                                     String url,
                                     CustomTabFallback fallback) {
        Log.i(TAG, "openCustomTab url: " + url);
        String packageName = CustomTabsHelper.getPackageNameToUse(activity);

        if (packageName == null) {
            if (fallback != null) {
                fallback.openUri(activity, url);
            }
        } else {
            Log.i(TAG, "launch Custom Tabs packageName: " + packageName + " url " + url );
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, Uri.parse(url));
        }
    }

    public interface CustomTabFallback {
        void openUri(Activity activity, String url);
    }

}