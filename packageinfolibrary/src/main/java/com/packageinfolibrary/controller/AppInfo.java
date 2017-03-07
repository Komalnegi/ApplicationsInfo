package com.packageinfolibrary.controller;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.packageinfolibrary.model.AppItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 3/7/2017.
 */

public class AppInfo {
    private Context context;
    private static AppInfo appInfo;
    List<ApplicationInfo> system_apps;
    List<ApplicationInfo> user_installed_apps = new ArrayList<>();
    PackageInfo packageInfo;

    public static AppInfo getAppInfo(Context context) {
        if (appInfo == null) {
            appInfo = new AppInfo(context);
        }
        return appInfo;
    }

    private AppInfo(Context context) {
        this.context = context;
    }

    public ArrayList<AppItem> getAllApps() {
        ArrayList<AppItem> itemList = new ArrayList<>();

        PackageManager pm = context.getPackageManager();
        system_apps = context.getPackageManager().getInstalledApplications(0); // use Flag instead

        for (ApplicationInfo app : system_apps) {
            if (!((app.flags & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP | ApplicationInfo.FLAG_SYSTEM)) > 0)) {
                // It is a system app
                user_installed_apps.add(app);
            }
        }

        for (int i = 0; i < user_installed_apps.size(); i++) {  // use foreach loop
            AppItem appItem = new AppItem();
            appItem.setPackageName(user_installed_apps.get(i).packageName.toString());
            itemList.add(new AppItem(user_installed_apps.get(i).packageName.toString(),
                    context.getPackageManager().getApplicationLabel(user_installed_apps.get(i)).toString(),
                    context.getPackageManager().getApplicationIcon(user_installed_apps.get(i))));  // ""getApplicationIcon" not valid fopr every application
        }

        return itemList;
    }


    public ArrayList<String> getActivities(String packageName) {
        ArrayList<String> activityList = new ArrayList<>();
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_ACTIVITIES);
            /*for(int i=0 ; i<pi.activities.length;i++){
                activityList.add(Arrays.asList(pi.activities).get(i).name);
            }*/

            for(ActivityInfo appInfo: pi.activities ){
                activityList.add(appInfo.name);
            }


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }finally {
            return activityList;
        }
    }

    public ArrayList<String> getServices(String PackageName) {
        ArrayList<String> activityList = new ArrayList<>();
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    PackageName, PackageManager.GET_ACTIVITIES);
            for(int i=0 ; i<pi.activities.length;i++){
                activityList.add(Arrays.asList(pi.services).get(i).name);
            }

            return activityList;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}


