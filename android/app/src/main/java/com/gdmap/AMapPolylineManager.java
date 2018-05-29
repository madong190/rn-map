package com.gdmap;

import android.view.View;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by madon on 2018/5/29.
 */

public class AMapPolylineManager extends SimpleViewManager {
    @Override
    public String getName() {
        return "AMapPolyline";
    }

    @Override
    protected View createViewInstance(ThemedReactContext reactContext) {
        return new AMapPolyline(reactContext);
    }
    @ReactProp(name = "coordinates")
    public void setCoordinate(AMapPolyline polyline,ReadableArray coordinates ) {
        polyline.setCoordinates(coordinates);
    }

    @ReactProp(name = "colors")
    public void setColors(AMapPolyline polyline,ReadableArray colors) {
        polyline.setColors(colors);
    }

    @ReactProp(name = "color", customType = "Color")
    public void setColor(AMapPolyline polyline, int color) {
        polyline.setColor(color);
    }

    @ReactProp(name = "width")
    public void setWidth(AMapPolyline polyline,float width ) {
        polyline.setWidth(width);
    }

    @ReactProp(name = "zIndex")
    public void setZIndex_(AMapPolyline polyline, float zIndex) {
        polyline.setZIndex(zIndex);
    }


    @ReactProp(name = "dashed")
    public void setDashed(AMapPolyline polyline,boolean dashed) {
        polyline.setDashed(dashed);
    }

}
