package com.ywang.rocket;

import com.ywang.rocket.R;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
         
        Button button3 = (Button) rootView.findViewById(R.id.button3);
        
        button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
				InviteFriendsToInstallRocketFragment inviteFriendsToInstallRocketFragment = new InviteFriendsToInstallRocketFragment();
				fragmentTransaction.replace(R.id.frame_container, inviteFriendsToInstallRocketFragment);
		        fragmentTransaction.addToBackStack(null);
		        fragmentTransaction.commit();
			}
		});
        
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "OK", Toast.LENGTH_SHORT).show();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				
				ChooseContentFragment chooseContentFragment = new ChooseContentFragment();
				fragmentTransaction.replace(R.id.frame_container, chooseContentFragment);
		        fragmentTransaction.addToBackStack(null);
		        fragmentTransaction.commit();
			}
		});
        
        return rootView;
    }
}
