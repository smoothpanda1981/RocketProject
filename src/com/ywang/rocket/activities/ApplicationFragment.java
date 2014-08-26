package com.ywang.rocket.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.ywang.rocket.R;
import com.ywang.rocket.adapter.CustomApplicationBaseAdapter;
import com.ywang.rocket.adapter.ImageAdapter;
public class ApplicationFragment extends Fragment {

	PackageManager packageManager;
//	GridView gridview;
	GridView apkList;
	
	public ApplicationFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(
				R.layout.fragment_choose_content_application, container, false);

		packageManager = getActivity().getPackageManager();
		List<PackageInfo> packageList1 = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
		
		List<PackageInfo> packageList = new ArrayList<PackageInfo>();
		
		/*To filter out System apps*/
        for(PackageInfo pi : packageList1) {
            if(!isSystemPackage(pi)) {
                packageList.add(pi);
            }
        }
		
//        gridview = (GridView) rootView.findViewById(R.id.gridView1);
//        gridview.setAdapter(new ImageAdapter(getActivity(), packageList, packageManager));
//        gridview.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				Toast.makeText(getActivity(), "" + 0, Toast.LENGTH_SHORT).show();
//			}
//		});     
        
        apkList = (GridView) rootView.findViewById(R.id.gridView1);
        
        CustomApplicationBaseAdapter adapter = new CustomApplicationBaseAdapter(getActivity(), packageList, packageManager);
        apkList.setAdapter(adapter);
        apkList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Toast.makeText(getActivity(), "" + 0, Toast.LENGTH_SHORT).show();
			}
		});
		return rootView;
	}
	
	
	private boolean isSystemPackage(PackageInfo pkgInfo) {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }
}
