package com.packagesinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {
    private ArrayList<String> activityList = new ArrayList<>();
    private ArrayList<String> serviceList = new ArrayList<>();
    private TextView mActivityName,mServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        mActivityName = (TextView)findViewById(R.id.txt_activity_name);
        mServiceList = (TextView) findViewById(R.id.txt_service_name);

        Intent i = getIntent();
        activityList = i.getStringArrayListExtra("activityList");
        serviceList = i.getStringArrayListExtra("serviceList");

        mActivityName.setText(activityList.toString());
        mServiceList.setText(serviceList.toString());
    }
}
