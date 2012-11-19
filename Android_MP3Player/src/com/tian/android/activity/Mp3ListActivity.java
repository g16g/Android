package com.tian.android.activity;

import com.example.android_mp3_01_player.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Mp3ListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp3_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mp3_list, menu);
        return true;
    }
}
