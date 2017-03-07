package com.packageinfolibrary.controller;

import com.packageinfolibrary.model.AppItem;

import java.util.ArrayList;

/**
 * Created by hp on 3/7/2017.
 */

public class App {
    private ArrayList<AppItem> appList;

    public ArrayList<AppItem> getAppList() {
        return appList;
    }

    public void setAppList(ArrayList<AppItem> appList) {
        this.appList = appList;
    }
}
