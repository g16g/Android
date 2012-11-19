package com.tian.android;

import com.tian.util.HttpDownloader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button text;
	private Button mp3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (Button)findViewById(R.id.text);
        mp3 = (Button)findViewById(R.id.mp3);
        
        text.setOnClickListener(new DownloadTextListener());
        mp3.setOnClickListener(new DownloadMp3Listener());
    }

    class DownloadTextListener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		String url = "http://music.baidu.com//data2/lrc/16580343/16580343.lrc";
    		HttpDownloader downloader = new HttpDownloader();
    		
    		System.out.println(downloader.download(url));
    		System.out.println("--over--");
    	}
    }
    
    class DownloadMp3Listener implements OnClickListener{
    	@Override
    	public void onClick(View v) {
    		String url = "http://music.baidu.com//data2/lrc/16580343/16580343.lrc";
    		HttpDownloader downloader = new HttpDownloader();
    		System.out.println(downloader.download(url, "tianyasheng/", "t.mp3"));;
    		System.out.println("---over---");
    	}
    }
}
