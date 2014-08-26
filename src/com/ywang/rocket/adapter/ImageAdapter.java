package com.ywang.rocket.adapter;

import java.util.List;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;
	private List<PackageInfo> mList;
	private PackageManager packageManager;

    public ImageAdapter(Context c, List<PackageInfo> list, PackageManager pm) {
        mContext = c;
        mList = list;
        packageManager = pm;
    }

    public int getCount() {
        return mList.size();
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(20, 20, 20, 20);
        } else {
            imageView = (ImageView) convertView;
        }
        
        PackageInfo packageInfo = (PackageInfo) getItem(position);
        Drawable appIcon = packageManager.getApplicationIcon(packageInfo.applicationInfo);
        String appName = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
        Log.i("AppName = ", appName);
        long appSize = packageInfo.firstInstallTime;
        Log.i("Appsize = ", String.valueOf(appSize));
        appIcon.setBounds(0, 0, 40, 40);
        
        imageView.setImageDrawable(appIcon);
    	
        return imageView;
    }
}
