package com.gdmap;

/**
 * Created by madon on 2018/5/28.
 */
import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class MapViewManager extends SimpleViewManager {
    @Override
    public String getName() {
        return "MapViewe";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        return new AMapView(reactContext);
    }
}