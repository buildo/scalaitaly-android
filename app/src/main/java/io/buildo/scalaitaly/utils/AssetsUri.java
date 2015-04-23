package io.buildo.scalaitaly.utils;

import android.util.Log;

/**
 * Created by andreaascari on 23/04/15.
 */
public class AssetsUri {

    public static String getAssetsUri(int resourceId) {
        String assetsUri = "res:///" + resourceId;
        Log.d("Getting assets uri..", assetsUri);

        return assetsUri;
    }
}
