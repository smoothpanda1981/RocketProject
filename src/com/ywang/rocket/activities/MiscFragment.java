package com.ywang.rocket.activities;

import com.ywang.rocket.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MiscFragment extends Fragment {

public MiscFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_choose_content_misc, container, false);
         
        return rootView;
    }
}
