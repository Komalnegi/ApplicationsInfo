package com.packageinfolibrary.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by hp on 3/7/2017.
 */

public class AppItem {
    private String packageName,
            app_name;
    private ArrayList<String> app_activity,
            app_service,
            app_receiver;
    private Drawable app_icon;
    public AppItem(){

    }

    public AppItem(String package_name, String app_name,Drawable app_icon) {
        this.packageName = package_name;
        this.app_name = app_name;
        this.app_icon = app_icon;
    }

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

    public ArrayList<String> getApp_activity() {
        return app_activity;
    }

    public void setApp_activity(ArrayList<String> app_activity) {
        this.app_activity = app_activity;
    }

    public ArrayList<String> getApp_service() {
        return app_service;
    }

    public void setApp_service(ArrayList<String> app_service) {
        this.app_service = app_service;
    }

    public ArrayList<String> getApp_receiver() {
        return app_receiver;
    }

    public void setApp_receiver(ArrayList<String> app_receiver) {
        this.app_receiver = app_receiver;
    }
}
