package com.tian.android.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

import com.tian.android.R;


public class MainActivity extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		TabHost tabHost = getTabHost();
		
		//网络列表
		Intent remoteIntent = new Intent();
		remoteIntent.setClass(this, Mp3ListActivity.class);
		TabHost.TabSpec remoteSpec = tabHost.newTabSpec("Remote");
		Resources r = getResources();
		remoteSpec.setIndicator("Remote", r.getDrawable(android.R.drawable.stat_sys_download));
		remoteSpec.setContent(remoteIntent);
		tabHost.addTab(remoteSpec);
		
		//本地列表
		Intent localIntent = new Intent();
		localIntent.setClass(this, LocalMp3ListActivity.class);
		TabHost.TabSpec localSpec = tabHost.newTabSpec("Local");
		localSpec.setIndicator("Local", r.getDrawable(android.R.drawable.stat_sys_upload));
		localSpec.setContent(localIntent);
		tabHost.addTab(localSpec);
		
	}

}
