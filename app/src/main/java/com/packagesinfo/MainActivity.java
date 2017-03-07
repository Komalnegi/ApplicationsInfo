package com.packagesinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.packageinfolibrary.controller.AppInfo;
import com.packageinfolibrary.model.AppItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mAppListRecyclerView;
    AppAdapter mAdapter;
    private AppInfo appInfo;
    private ArrayList<String> activityList = new ArrayList<>();
    private ArrayList<String> serviceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppListRecyclerView = (RecyclerView)
                findViewById(R.id.app_list_recycler_view);
        mAppListRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));


        appInfo = AppInfo.getAppInfo(MainActivity.this);

        Log.v("activities_name",appInfo.getActivities("com.facebook.katana").toString());
        final ArrayList<AppItem> appItems = appInfo.getAllApps();

        mAdapter = new AppAdapter(appItems);
        mAppListRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AppAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                activityList = appInfo.getActivities(appItems.get(position).getPackageName());
                serviceList = appInfo.getServices(appItems.get(position).getPackageName());
                Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                intent.putStringArrayListExtra("activityList",activityList);
                intent.putStringArrayListExtra("serviceList",serviceList);
                startActivity(intent);
            }
        });
    }
}
