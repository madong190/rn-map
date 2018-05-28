package com.gdmap;

/**
 * Created by madon on 2018/5/28.
 */
import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MapViewManager extends SimpleViewManager {
    @Override
    public String getName() {
        return "AMapView";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        return new AMapView(reactContext);
    }
    @ReactProp(name = "showsCompass")
    public void setCompassEnabled(AMapView view, Boolean show ) {
        view.map.getUiSettings().setCompassEnabled(show);
    }
    @ReactProp(name = "showsZoomControls")
    public void setZoomControlsEnabled(AMapView view, Boolean enabled ) {
        view.map.getUiSettings().setZoomControlsEnabled(enabled);
    }

    @ReactProp(name = "showsScale")
    public void setScaleControlsEnabled(AMapView view, Boolean enabled ) {
        view.map.getUiSettings().setScaleControlsEnabled(enabled);
    }

    @ReactProp(name = "showsLocationButton")
    public void setMyLocationButtonEnabled(AMapView view, Boolean enabled ) {
        view.map.getUiSettings().setMyLocationButtonEnabled(enabled);
    }
    @ReactProp(name = "locationEnabled")
    public void  setMyLocationEnabled(AMapView view, Boolean enabled) {
        view.map.setMyLocationEnabled(enabled);
    }
}