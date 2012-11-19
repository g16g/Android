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
     * ���û����MENU��ť֮�����ø÷��������ǿ���������������м����Լ��İ�ť�ؼ�
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
			//�û�����˸��°�ť
		}else if(item.getItemId() == ABOUT){
			//�û�����˹��ڰ�ť
		}
		return super.onOptionsItemSelected(item);
	}
    

}
