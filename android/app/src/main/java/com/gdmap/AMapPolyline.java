package com.gdmap;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.AMapGLOverlay;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.view.ColorUtil;
import com.facebook.react.views.view.ReactViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madon on 2018/5/29.
 */

public class AMapPolyline extends ReactViewGroup {
    public boolean dashed;
    public float zIndex;
    public float width;
    public int color;
    private List<Integer> colors;
    private List<LatLng> coordinates;
    private Polyline polyline;

    public AMapPolyline(Context context) {
        super(context);
    }
    public void setColors(ReadableArray colors ) {
        this.colors = new ArrayList(colors.size());
        for(int i = 0;i<colors.size();i++){
            this.colors.add(Color.parseColor(colors.getString(i)));
        }
    }

    public void setCoordinates(ReadableArray coordinates) {
        this.coordinates = new ArrayList(coordinates.size());
        for(int i = 0;i<coordinates.size();i++){
            ReadableMap map =  coordinates.getMap(i);
            this.coordinates.add(new LatLng(map.getDouble("latitude"),map.getDouble("longitude")));
        }
        if (polyline != null) {
            polyline.setPoints(this.coordinates);
        }

    }


    public void setColor(int color) {
        this.color = color;
        if(polyline!=null){
            polyline.setColor(color);
        }
    }

    public void setWidth(float width) {
        this.width = width;
        if(polyline!=null){
            polyline.setWidth(width);
        }
    }

    public void setZIndex(float zIndex) {
        this.zIndex = zIndex;
        if(polyline!=null){
            polyline.setZIndex(zIndex);
        }
    }

    public void setDashed(boolean dashed) {
        this.dashed = dashed;
        if(polyline!=null){
            polyline.setDottedLine(dashed);
        }
    }

    public void addToMap(AMap map) {
        polyline = map.addPolyline(new PolylineOptions()
                .addAll(coordinates)
                .color(color)
                .colorValues(colors)
                .width(width)
                .setDottedLine(dashed)
                .zIndex(zIndex));
    }

    public String getPolylineId() {
         return polyline.getId();
    }
}
