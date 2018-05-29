package com.gdmap;

/**
 * Created by madon on 2018/5/28.
 */
import android.util.Log;
import android.view.View;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;

import javax.annotation.Nullable;

public class MapViewManager extends ViewGroupManager<AMapView> {
    public ReactContext context;
    RCTEventEmitter eventEmitter ;
    @Override
    public String getName() {
        return "AMapView";
    }

    @Override
    protected AMapView createViewInstance(ThemedReactContext reactContext) {
        context = reactContext;
        eventEmitter = reactContext.getJSModule(RCTEventEmitter.class);
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
    @Override
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(
                "onPress", MapBuilder.of("registrationName", "onPress"),
                "onLocaltionChange", MapBuilder.of("registrationName", "onLocaltionChange"),
                "onCameraChange", MapBuilder.of("registrationName", "onCameraChange"),
                "onCameraChangeFinish", MapBuilder.of("registrationName", "onCameraChangeFinish")
        );
    }
    @Override
    public void addView(AMapView mapView, View child, int index) {
        if(child instanceof AMapPolyline){
            mapView.addPolyline((AMapPolyline) child);
        }
    }
}