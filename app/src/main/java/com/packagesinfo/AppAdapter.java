package com.packagesinfo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.packageinfolibrary.model.AppItem;


import java.util.ArrayList;

/**
 * Created by hp on 1/5/2017.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {

    /***** Creating OnItemClickListener *****/

    // Define listener member variable
    private static OnItemClickListener listener;
    // Define the listener interface
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }
    // Define the method that allows the parent activity or fragment to define the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private ArrayList<AppItem> appList ;

    public AppAdapter(ArrayList<AppItem> appList) {
        this.appList = appList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView app_name , package_name;
        private ImageView app_icon;

        public ViewHolder( View v) {
            super(v);
            app_name = (TextView) v.findViewById(R.id.txt_appName);
            package_name = (TextView) v.findViewById(R.id.txt_package_name);
            app_icon = (ImageView) v.findViewById(R.id.img_app_icon);

            // Setup the click listener
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.app_name.setText(appList.get(position).getApp_name());
        holder.package_name.setText(appList.get(position).getPackageName());
        holder.app_icon.setImageDrawable(appList.get(position).getApp_icon());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }
}
