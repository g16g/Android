package com.tian.android.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_mp3_01_player.R;

public class Mp3ListActivity extends ListActivity {

	private static final int UPDATE = 1;
	private static final int ABOUT = 2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_list);
    }

    /**
     * 在用户点击MENU按钮之后会调用该方法，我们可以在这个方法当中加入自己的按钮控件
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, UPDATE, 1, R.string.mp3list_update);
		menu.add(0, ABOUT, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println("itemId = "+item.getItemId());
		if(item.getItemId() == UPDATE){
			//用户点击了更新按钮
		}else if(item.getItemId() == ABOUT){
			//用户点击了关于按钮
		}
		return super.onOptionsItemSelected(item);
	}
    

}
