package com.gdmap;

import android.graphics.Bitmap;
import android.os.Environment;

import com.amap.api.maps.AMap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by madon on 2018/5/30.
 */

public class ScreenShotMoudle extends ReactContextBaseJavaModule {
    MapViewManager mapViewManager;
    public ScreenShotMoudle(ReactApplicationContext reactContext,MapViewManager mapViewManager) {
        super(reactContext);
        this.mapViewManager = mapViewManager;
    }

    @Override
    public String getName() {
        return "AMapScreenShot";
    }
    @ReactMethod
    public void ScreenShot(String message,final Promise pro){
        mapViewManager.getAMapView().getMap().getMapScreenShot(new AMap.OnMapScreenShotListener() {
            @Override
            public void onMapScreenShot(Bitmap bitmap) {
            }

            @Override
            public void onMapScreenShot(Bitmap bitmap, int status) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                if(null == bitmap){
                    return;
                }
                try {
                    String name ="test_"+ sdf.format(new Date()) + ".png";
                    FileOutputStream fos = new FileOutputStream(
                            Environment.getExternalStorageDirectory() + "/"+name);
                    boolean b = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    try {
                        fos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    StringBuffer buffer = new StringBuffer();
                    if (b)
                        buffer.append("截屏成功 ");
                    else {
                        buffer.append("截屏失败 ");
                    }
                    if (status != 0)
                        buffer.append("地图渲染完成，截屏无网格 ");
                    else {
                        buffer.append( "地图未渲染完成，截屏有网格 ");
                    }
                    buffer.append("文件名称：").append(name);
                    pro.resolve(buffer.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
