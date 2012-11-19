package com.tian.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button startB = null;
	private Button endB = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB = (Button)findViewById(R.id.startB);
        endB = (Button) findViewById(R.id.endB);
        startB.setOnClickListener(new StartService());
        endB.setOnClickListener(new EndService());
    }

    class StartService implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		System.out.println("------------------");
    		Intent intent = new Intent();
    		intent.setClass(MainActivity.this, MyService.class);
    		startService(intent);
    	}
    }
    
    class EndService implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		System.out.println("******************");
    		Intent intent = new Intent();
    		intent.setClass(MainActivity.this, MyService.class);
    		stopService(intent);
    	}
    }
}
