package com.example.android.network.sync.basicsyncadapter;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Ivan on 22/10/2014.
 */
public class App extends Application {


    @Override
    public void onTerminate() {
        super.onTerminate();
        //VolleyRequestController.getInstance(this).getRequestQueue().stop();
        //DownloadRDSManager.getInstance().unbindRDSService(this);
        ActiveAndroid.dispose();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //DownloadManager.get().startRDService(this);
        //VolleyRequestController.getInstance(this).getRequestQueue().start();
        //DownloadRDSManager.getInstance().bindRDService(this);
        //CacheDataManager.get().setContext(this);
        ActiveAndroid.initialize(this);
    }
}
