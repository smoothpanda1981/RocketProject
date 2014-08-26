package com.ywang.rocket;

import com.ywang.rocket.activities.ApplicationFragment;
import com.ywang.rocket.activities.MiscFragment;
import com.ywang.rocket.activities.MusicFragment;
import com.ywang.rocket.activities.PicturesFragment;
import com.ywang.rocket.activities.VideoFragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;

public class ChooseContentFragment extends Fragment implements OnTabChangeListener {
	
	private static final String TAG = "FragmentTabs";
	public static final String TAB_APPLICATION = "Apps";
	public static final String TAB_PICTURES = "Pictures";
	public static final String TAB_MUSIC = "Music";
	public static final String TAB_VIDEO = "Video";
	public static final String TAB_MISC = "Misc";

	
	private View mRoot;
	private TabHost mTabHost;
	private int mCurrentTab; 
	private int[] imageIconIntTrue = new int[] {R.drawable.ic_app_on, R.drawable.ic_picture_on, R.drawable.ic_music_on, R.drawable.ic_video_on, R.drawable.ic_misc_on};
	private int[] imageIconIntFalse = new int[] {R.drawable.ic_app_off, R.drawable.ic_picture_off, R.drawable.ic_music_off, R.drawable.ic_video_off, R.drawable.ic_misc_off};;
	
	public ChooseContentFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		mRoot = inflater.inflate(R.layout.fragment_choose_content, container, false);
		
		mTabHost = (TabHost) mRoot.findViewById(android.R.id.tabhost);

		setTabs();
		mTabHost.setCurrentTab(0); 
        
        return mRoot;
    }
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		// manually start loading stuff in the first tab
		updateTab(TAB_APPLICATION, R.id.tab1, new ApplicationFragment());
	}
	
	
	private void setTabs() {
		mTabHost.setup();	
		mTabHost.addTab(newTab(TAB_APPLICATION, R.string.tab_text_1, R.id.tab1, R.drawable.ic_app_off));
		mTabHost.addTab(newTab(TAB_PICTURES, R.string.tab_text_2, R.id.tab2, R.drawable.ic_picture_off));
		mTabHost.addTab(newTab(TAB_MUSIC, R.string.tab_text_3, R.id.tab3, R.drawable.ic_music_off));
		mTabHost.addTab(newTab(TAB_VIDEO, R.string.tab_text_4, R.id.tab4, R.drawable.ic_video_off));
		mTabHost.addTab(newTab(TAB_MISC, R.string.tab_text_5, R.id.tab5, R.drawable.ic_misc_off));
//	    addTab(R.drawable.ic_app_off, ApplicationActivity.class, "Apps", R.id.tab1, R.drawable.icon_application);
//	    addTab(R.drawable.ic_picture_off, PictureActivity.class, "Pictures", R.id.tab2, R.drawable.icon_picture);
//	    addTab(R.drawable.ic_music_off, MusicActivity.class, "Music", R.id.tab3, R.drawable.icon_music);
//	    addTab(R.drawable.ic_video_off, VideoActivity.class, "Videos", R.id.tab4, R.drawable.icon_video);
//	    addTab(R.drawable.ic_misc_off, MiscActivity.class, "Misc", R.id.tab5, R.drawable.icon_misc);
	}
	
	private TabSpec newTab(String tag, int labelId, int tabContentId, int drawableId) {
		Log.d(TAG, "buildTab(): tag=" + tag);

		View tabIndicator = LayoutInflater.from(getActivity()).inflate(R.layout.tab_indicator, (ViewGroup) mRoot.findViewById(android.R.id.tabs), false);
//		tabIndicator.setBackground(getResources().getDrawable(drawableIconId));
		
	    TextView title = (TextView) tabIndicator.findViewById(R.id.title);
	    title.setText(labelId);
	    
	    ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
	    icon.setImageResource(drawableId);
		
		TabSpec tabSpec = mTabHost.newTabSpec(tag);
		tabSpec.setIndicator(tabIndicator);
		tabSpec.setContent(tabContentId);
		return tabSpec;
	}
	
//	private void addTab(int drawableId, Class<?> c, String labelId, int tabId, int drawableIconId) {
//		final TabHost tabHost = mTabHost;
//		Intent intent = new Intent(getActivity(), c);
//		TabHost.TabSpec spec = mTabHost.newTabSpec("tab"+ labelId);  
//
//	    View tabIndicator = LayoutInflater.from(getActivity()).inflate(R.layout.tab_indicator, (ViewGroup) mRoot.findViewById(android.R.id.tabs), false);
//	    
//	    tabIndicator.setBackground(getResources().getDrawable(drawableIconId));
//		
//	    TextView title = (TextView) tabIndicator.findViewById(R.id.title);
//	    title.setText(labelId);
//	    
//	    ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
//	    icon.setImageResource(drawableId);
//	    spec.setIndicator(tabIndicator);
//	    spec.setContent(tabId);
//	    
//	    tabHost.addTab(spec);
//	}
	
	
	@Override
	public void onTabChanged(String tabId) {
		Log.d(TAG, "onTabChanged(): tabId=" + tabId);
		
		Fragment currentFragment = null;
		int placeholder = 0;
		
		if (TAB_APPLICATION.equals(tabId)) {
			currentFragment = new ApplicationFragment();
			placeholder = R.id.tab1;
			mCurrentTab = 0;
		}
		if (TAB_PICTURES.equals(tabId)) {
			currentFragment = new PicturesFragment();
			placeholder = R.id.tab2;
			mCurrentTab = 1;
		}
		if (TAB_MUSIC.equals(tabId)) {
			currentFragment = new MusicFragment();
			placeholder = R.id.tab3;
			mCurrentTab = 2;
		}
		if (TAB_VIDEO.equals(tabId)) {
			currentFragment = new VideoFragment();
			placeholder = R.id.tab4;
			mCurrentTab = 3;
		}
		if (TAB_MISC.equals(tabId)) {
			currentFragment = new MiscFragment();
			placeholder = R.id.tab5;
			mCurrentTab = 4;
		}
		updateTab(tabId, placeholder, currentFragment);
	}

	private void updateTab(String tabId, int placeholder, Fragment fragment) {
		FragmentManager fm = getFragmentManager();
		
		ViewGroup group = (ViewGroup) mRoot.findViewById(android.R.id.tabs);
		int counter = group.getChildCount();
		
		for(int i = 0; i < counter; i++) {
			View view = group.getChildAt(i);
			TextView title = (TextView) view.findViewById(R.id.title);
			ImageView icon = (ImageView) view.findViewById(R.id.icon);
			if (i == mCurrentTab) {
				title.setTextColor(getResources().getColor(R.color.action_bar_background_color));
				icon.setImageResource(imageIconIntTrue[i]);
			} else {
				title.setTextColor(getResources().getColor(R.color.grey_color));
				icon.setImageResource(imageIconIntFalse[i]);
			}
		}
		
		if (fm.findFragmentByTag(tabId) == null) {		   
		   fm.beginTransaction().replace(placeholder, fragment, tabId).commit();
		}
	}

}
