package com.ywang.rocket.adapter;

import java.io.File;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ywang.rocket.R;
import com.ywang.rocket.activities.PictureData;

public class CustomPictureBaseAdapter extends BaseAdapter {
	
	List<PictureData> imageList;
    Context context;
    PackageManager packageManager;
    
    public CustomPictureBaseAdapter(Context context, List<PictureData> list) {
        this.context = context;
        this.imageList = list;
    }
     
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView imageCollectionName;
        TextView imageCollectionQuantity;
        Button selectAllButton;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
         
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.apk_picture_list_item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageThumbnail);
            holder.imageCollectionName = (TextView) convertView.findViewById(R.id.imagecollectionname);
            holder.imageCollectionQuantity = (TextView) convertView.findViewById(R.id.imagecollectionquantity);
            holder.selectAllButton = (Button) convertView.findViewById(R.id.picture_button1);
            
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
         
 
        PictureData pictureData = (PictureData) getItem(position);
        String imageFilePath = pictureData.getImageFilePath();
        Drawable d = Drawable.createFromPath(imageFilePath);
        
        String appName = pictureData.getName();
        String quantity = String.valueOf(pictureData.getQuantity());
        Log.i("AppName = ", appName);
        
//        Log.i("Appsize = ", String.valueOf(packageInfo.versionCode));
        d.setBounds(40, 40, 40, 40);
        
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.imageView.setPadding(10, 10, 10, 10);
        holder.imageView.setLayoutParams(new RelativeLayout.LayoutParams(140, 140));
        holder.imageView.setImageDrawable(d);
        
        holder.imageCollectionName.setText(appName);
        
        holder.imageCollectionQuantity.setText(quantity);
        
        return convertView;
    }
 
    @Override
    public int getCount() {     
        return imageList.size();
    }
 
    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return imageList.indexOf(getItem(position));
    }
}
