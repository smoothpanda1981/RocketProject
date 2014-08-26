package com.ywang.rocket;

import com.ywang.rocket.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class InviteFriendsToInstallRocketFragment extends Fragment {
	
	public InviteFriendsToInstallRocketFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_invite_friends_to_install_rocket, container, false);
         
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "button 1", Toast.LENGTH_SHORT).show();
			}
		});
        
        Button button2 = (Button) rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "button 2", Toast.LENGTH_SHORT).show();
			}
		});
        
        Button button3 = (Button) rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "button 3", Toast.LENGTH_SHORT).show();
			}
		});
        
        Button button4 = (Button) rootView.findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "button 4", Toast.LENGTH_SHORT).show();
			}
		});
        
        return rootView;
    }
	
//	public void bluetoothButtonOnClick(View view) {
//		Toast.makeText(getActivity(), "button 1", Toast.LENGTH_SHORT).show();
//	}
//	
//	public void zeroShareButtonOnClick(View view) {
//		Toast.makeText(getActivity(), "button 2", Toast.LENGTH_SHORT).show();
//	}
//
//	public void messageButtonOnClick(View view) {
//		Toast.makeText(getActivity(), "button 3", Toast.LENGTH_SHORT).show();
//	}
//
//	public void qrCodeButtonOnClick(View view) {
//		Toast.makeText(getActivity(), "button 4", Toast.LENGTH_SHORT).show();
//	}
}
