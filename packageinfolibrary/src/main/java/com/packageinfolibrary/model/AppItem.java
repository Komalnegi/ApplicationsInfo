package com.packageinfolibrary.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by hp on 3/7/2017.
 */

public class AppItem {
    private String packageName,
            app_name;
    private Drawable app_icon;
    public AppItem(){

    }

    /*public AppItem(String package_name, String app_name,Drawable app_icon) // no need to create construcotr here , instead use setter getter
    {
        this.packageName = package_name;
        this.app_name = app_name;
        this.app_icon = app_icon;
    }*/

    public Drawable getApp_icon() {
        return app_icon;
    }

    public void setApp_icon(Drawable app_icon) {
        this.app_icon = app_icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }
}
