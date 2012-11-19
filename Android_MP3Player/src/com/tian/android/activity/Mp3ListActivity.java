package com.tian.android.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android_mp3_01_player.R;

public class Mp3ListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_list);
    }

    /**
     * ���û����MENU��ť֮�����ø÷��������ǿ���������������м����Լ��İ�ť�ؼ�
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 1, R.string.mp3list_update);
		menu.add(0, 2, 2, R.string.mp3list_about);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		System.out.println("itemId = "+item.getItemId());
		return super.onOptionsItemSelected(item);
	}
    

}
