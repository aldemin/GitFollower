package com.alexandr.demin.gitfollower.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

import com.alexandr.demin.gitfollower.App;

public class NetworkStatus
{
    private final String TAG = "NetworkStatus";

    private App app;

    public enum Status
    {
        WIFI,
        MOBILE,
        ETHERNET,
        OFFLINE
    }

    private Status currentStatus = Status.OFFLINE;

    public NetworkStatus(App app) {
        this.app = app;
    }

    private boolean isAirplane()
    {
        return Settings.Global.getInt(app.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    public Status getStatus() {
        ConnectivityManager cm = (ConnectivityManager) app.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
            {
                currentStatus = Status.WIFI;
            }

            if(activeNetwork.getType() == ConnectivityManager.TYPE_ETHERNET)
            {
                currentStatus = Status.ETHERNET;
            }

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                currentStatus = Status.MOBILE;
            }
        }
        else
        {
            currentStatus = Status.OFFLINE;
        }

        return currentStatus;
    }


    public boolean isOnline()
    {
        getStatus();
        return currentStatus.equals(Status.WIFI) || currentStatus.equals(Status.MOBILE) || currentStatus.equals(Status.ETHERNET);
    }

    public boolean isWifi()
    {
        return getStatus().equals(Status.WIFI);
    }

    public boolean isEthernet()
    {
        return getStatus().equals(Status.ETHERNET);
    }

    public boolean isMobile()
    {
        return getStatus().equals(Status.MOBILE);
    }

    public boolean isOffline()
    {
        return getStatus().equals(Status.OFFLINE);
    }
}
