package com.ywang.rocket;

import com.ywang.rocket.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class QuickGuideFragment extends Fragment {
	
	public QuickGuideFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_quick_guide, container, false);
         
        return rootView;
    }
}
