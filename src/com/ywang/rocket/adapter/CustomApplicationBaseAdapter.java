package com.ywang.rocket.adapter;

import java.util.List;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ywang.rocket.R;

public class CustomApplicationBaseAdapter extends BaseAdapter {
	
	List<PackageInfo> packageList;
    Context context;
    PackageManager packageManager;
    
    public CustomApplicationBaseAdapter(Context context, List<PackageInfo> list, PackageManager pm) {
        this.context = context;
        this.packageList = list;
        this.packageManager = pm;
    }
     
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtName;
        TextView txtSize;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
         
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.apk_application_list_item, null);
            holder = new ViewHolder();
            holder.txtSize = (TextView) convertView.findViewById(R.id.appsize);
            holder.txtName = (TextView) convertView.findViewById(R.id.appname);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageicon);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
         
 
        PackageInfo packageInfo = (PackageInfo) getItem(position);
        Drawable appIcon = packageManager.getApplicationIcon(packageInfo.applicationInfo);
        String appName = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
        Log.i("AppName = ", appName);
        
//        Log.i("Appsize = ", String.valueOf(packageInfo.versionCode));
        appIcon.setBounds(40, 40, 40, 40);
        
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(10, 10, 10, 10);
        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams(140, 140));
        holder.imageView.setImageDrawable(appIcon);
        
        holder.txtName.setText(appName);
        
        holder.txtSize.setText("");
        
        return convertView;
    }
 
    @Override
    public int getCount() {     
        return packageList.size();
    }
 
    @Override
    public Object getItem(int position) {
        return packageList.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return packageList.indexOf(getItem(position));
    }
}
