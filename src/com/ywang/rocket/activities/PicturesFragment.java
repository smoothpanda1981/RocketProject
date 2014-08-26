package com.ywang.rocket.activities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.ywang.rocket.R;
import com.ywang.rocket.adapter.CustomApplicationBaseAdapter;
import com.ywang.rocket.adapter.CustomPictureBaseAdapter;

public class PicturesFragment extends Fragment {

	ListView apkList;
	
	public PicturesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_choose_content_picture, container, false);
        

        List<PictureData> imageList = new ArrayList<PictureData>();
        String path = Environment.getExternalStorageDirectory().toString()+"/DCIM/Camera";
        Log.d("Files", "Path: " + path);
        File f = new File(path);        
        File[] file = f.listFiles();
        Log.d("Files", "Size: "+ file.length);
        boolean getIt = false;
        int counter = 0;
        String currentImageFile = null;
        for (int i=0; i < file.length; i++) {
        	Log.d("Files", "Filepath:" + file[i].getAbsolutePath());
            Log.d("Files", "FileName:" + file[i].getName());
            ImageFileFilter fileFilter = new ImageFileFilter(file[i]);
            if (fileFilter.accept(file[i])) {
            	if (!getIt) {
            		currentImageFile = file[i].getAbsolutePath();
                	getIt = true;	
            	}
            	counter++;
            }
        }
        PictureData pictureData = new PictureData();
        pictureData.setImageFilePath(currentImageFile);
        pictureData.setName("Camera");
        pictureData.setQuantity(counter);
        imageList.add(pictureData);
        
        path = Environment.getRootDirectory().toString()+"/WhatsApp/Media/WhatsApp Images";
        Log.d("Files", "Path: " + path);
        f = new File(path);        
        file = f.listFiles();
        Log.d("Files", "Size: "+ file.length);
        getIt = false;
        counter = 0;
        currentImageFile = null;
        for (int i=0; i < file.length && !getIt; i++) {
        	Log.d("Files", "Filepath:" + file[i].getAbsolutePath());
            Log.d("Files", "FileName:" + file[i].getName());
            ImageFileFilter fileFilter = new ImageFileFilter(file[i]);
            if (fileFilter.accept(file[i])) {
            	if (!getIt) {
            		currentImageFile = file[i].getAbsolutePath();
                	getIt = true;	
            	}
            	counter++;
            }
        }
        pictureData = new PictureData();
        pictureData.setImageFilePath(currentImageFile);
        pictureData.setName("WhatsApp Images");
        pictureData.setQuantity(counter);
        imageList.add(pictureData);
        
        path = Environment.getDataDirectory().toString()+"/tencent/MicroMsg/WeChat";
        Log.d("Files", "Path: " + path);
        f = new File(path);        
        file = f.listFiles();
        Log.d("Files", "Size: "+ file.length);
        getIt = false;
        counter = 0;
        currentImageFile = null;
        for (int i=0; i < file.length && !getIt; i++) {
        	Log.d("Files", "Filepath:" + file[i].getAbsolutePath());
            Log.d("Files", "FileName:" + file[i].getName());
            ImageFileFilter fileFilter = new ImageFileFilter(file[i]);
            if (fileFilter.accept(file[i])) {
            	if (!getIt) {
            		currentImageFile = file[i].getAbsolutePath();
                	getIt = true;	
            	}
            	counter++;
            }
        }
        pictureData = new PictureData();
        pictureData.setImageFilePath(currentImageFile);
        pictureData.setName("WeChat Images");
        pictureData.setQuantity(counter);
        imageList.add(pictureData);
        
        apkList = (ListView) rootView.findViewById(R.id.listView1);
        
        CustomPictureBaseAdapter adapter = new CustomPictureBaseAdapter(getActivity(), imageList);
        apkList.setAdapter(adapter);
        apkList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Toast.makeText(getActivity(), "" + 0, Toast.LENGTH_SHORT).show();
			}
		});
        
        return rootView;
    }
	
//	@Override
//	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//	     super.onActivityResult(requestCode, resultCode, data);
//	      
//	     Uri selectedImage = data.getData();
//	         String[] filePathColumn = { MediaStore.Images.Media.DATA };
//	 
//	         Cursor cursor = getActivity().getContentResolver().query(selectedImage,
//	                 filePathColumn, null, null, null);
//	         cursor.moveToFirst();
//	 
//	         int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//	         String picturePath = cursor.getString(columnIndex);
//	         cursor.close();
//	                      
//	         // String picturePath contains the path of selected Image
//	}
}