package com.gdmap;


import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madon on 2018/5/28.
 */

public class MapPackage implements ReactPackage {
    private MapViewManager mapViewManager = new MapViewManager();
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> list = new ArrayList<NativeModule>();
        list.add(new ScreenShotMoudle(reactContext,mapViewManager));
        return list;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> list = new ArrayList<ViewManager>();
        list.add(mapViewManager);
        list.add(new AMapPolylineManager());
        return list;
    }
}
