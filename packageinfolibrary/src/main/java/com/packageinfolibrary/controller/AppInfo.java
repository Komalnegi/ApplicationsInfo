package com.packageinfolibrary.controller;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.Drawable;

import com.packageinfolibrary.R;
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
    private static int INSTALLED_APPS = 0;

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
        system_apps = context.getPackageManager().getInstalledApplications(INSTALLED_APPS); // use Flag always e.g. INSTALLED_APPS here

        for (ApplicationInfo app : system_apps) {
            if (!((app.flags & (ApplicationInfo.FLAG_UPDATED_SYSTEM_APP | ApplicationInfo.FLAG_SYSTEM)) > 0)) { // if you don't want anything to happen in "if"
                // block then instead of using if-else block use not(!) in if block and correspondingly write code in if block

                user_installed_apps.add(app);
            }
        }

        for(ApplicationInfo applicationInfo : user_installed_apps){
            AppItem appItem = new AppItem();
            appItem.setPackageName(applicationInfo.packageName.toString());  // use setter getter instead of constructor here(commented part below is using constructor)
            appItem.setApp_name(context.getPackageManager().getApplicationLabel(applicationInfo).toString());
            appItem.setApp_icon(context.getPackageManager().getApplicationIcon(applicationInfo));
            itemList.add(appItem);
        }

        return itemList;
    }


    public ArrayList<String> getActivities(String packageName) {
        ArrayList<String> activityList = new ArrayList<>();
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_ACTIVITIES);
            /*for(int i=0 ; i<pi.activities.length;i++){   //use foreach loop instead
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

    public ArrayList<String> getServices(String packageName) {
        ArrayList<String> serviceList = new ArrayList<>();
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_SERVICES);

            for(ServiceInfo serviceInfo: pi.services ){
                serviceList.add(serviceInfo.name);
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }finally {
            return serviceList;
        }
    }

    public Drawable getIcon(String packageName) {
        Drawable drawable = context.getResources().getDrawable( R.drawable.loading_icon );;
        try {
            drawable = context.getPackageManager().getApplicationIcon(packageName);
        }
        catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }finally {
            return drawable;
        }
    }
}


