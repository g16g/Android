package com.tian.android.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tian.android.R;
import com.tian.android.model.Mp3Info;
import com.tian.android.utils.FileUtils;

public class LocalMp3ListActivity extends ListActivity {

	private List<Mp3Info> mp3s = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_mp3_list);
    }
    
    @Override
    protected void onResume() {
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	mp3s = new FileUtils().getMp3Fils("mp3/");
    	for (Mp3Info mp3Info : mp3s) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("mp3.name", mp3Info.getMp3Name());
			map.put("mp3.size", mp3Info.getMp3Size());
			list.add(map);
		}
    	SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.mp3info_item ,new String[]{"mp3.name","mp3.size"}, new int[]{R.id.mp3_name,R.id.mp3_size});
    	setListAdapter(adapter);
    	super.onResume();
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Mp3Info mp3Info = mp3s.get(position);
		Intent intent = new Intent();
		intent.putExtra("mp3", mp3Info);
		intent.setClass(this, Mp3PlayerActivity.class);
		startActivity(intent);
	}

}
