package com.tian.android.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.tian.android.R;
import com.tian.android.model.Mp3Info;
import com.tian.android.utils.FileUtils;

public class LocalMp3ListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_mp3_list);
        System.out.println("******************");
    }
    
    @Override
    protected void onResume() {
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	List<Mp3Info> mp3s = new FileUtils().getMp3Fils("mp3/");
    	for (Mp3Info mp3Info : mp3s) {
			Map<String,String> map = new HashMap<String, String>();
			map.put("mp3.name", mp3Info.getMp3Name());
			map.put("mp3.size", mp3Info.getMp3Size());
			list.add(map);
			System.out.println("--"+mp3Info);
		}
    	SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.mp3info_item ,new String[]{"mp3.name","mp3.size"}, new int[]{R.id.mp3_name,R.id.mp3_size});
    	setListAdapter(adapter);
    	super.onResume();
    }

}
