package com.gdmap;


import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by madon on 2018/5/28.
 */

public class AMapView extends MapView {
    public AMap map;
    public ReactContext context;
    private MapViewManager mvm;
    public AMapView(ReactContext context,MapViewManager mvm) {
        super(context);
        super.onCreate(null);
        map = getMap();
        this.mvm  = mvm;
        this.init();
    }

    private void init() {
        //可视区域变化
        map.setOnCameraChangeListener(new AMap.OnCameraChangeListener(){
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                WritableMap event = Arguments.createMap();
                event.putDouble("zoom", cameraPosition.zoom);
                AMapView.this.sendEvent(event,"onCameraChange");
            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {
                WritableMap event = Arguments.createMap();
                event.putDouble("zoom", cameraPosition.zoom);
                event.putDouble("latitude", cameraPosition.target.latitude);
                event.putDouble("longitude", cameraPosition.target.longitude);
                event.putString("southwest", map.getProjection().getVisibleRegion().latLngBounds.southwest.longitude+";"+ map.getProjection().getVisibleRegion().latLngBounds.southwest.latitude);
                AMapView.this.sendEvent(event,"onCameraChangeFinish");
            }
        });
        //定位变化
        map.setOnMyLocationChangeListener(new AMap.OnMyLocationChangeListener(){

            @Override
            public void onMyLocationChange(Location location) {
                WritableMap event = Arguments.createMap();
                event.putDouble("latitude", location.getLatitude());
                event.putDouble("longitude", location.getLongitude());
                AMapView.this.sendEvent(event,"onLocaltionChange");
            }
        });
        //点击事件
        map.setOnMapClickListener(new AMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                WritableMap event = Arguments.createMap();
                event.putDouble("latitude", latLng.latitude);
                event.putDouble("longitude", latLng.longitude);
                AMapView.this.sendEvent(event,"onPress");
            }
        });
    }

    /**
     * 向js添加事件
     * @param event
     */
    private void sendEvent(WritableMap event, String eventName) {
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                eventName,
                event);


    }

}
