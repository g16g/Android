package com.tian.android.activity;

import java.io.File;

import android.R.bool;
import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.tian.android.R;
import com.tian.android.model.Mp3Info;

public class Mp3PlayerActivity extends Activity {

	private ImageButton begin = null;
	private ImageButton pause = null;
	private ImageButton stop = null;

	private Mp3Info mp3 = null;
	private MediaPlayer mediaPlayer = null;

	private boolean isPlay = false;
	private boolean isPause = false;
	private boolean isReleased = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mp3player);
		begin = (ImageButton) findViewById(R.id.begin);
		pause = (ImageButton) findViewById(R.id.pause);
		stop = (ImageButton) findViewById(R.id.stop);

		begin.setOnClickListener(new beginLinstener());
		pause.setOnClickListener(new pauseLinstener());
		stop.setOnClickListener(new stopLinstener());

		mp3 = (Mp3Info) getIntent().getSerializableExtra("mp3");
	}

	class beginLinstener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (null != mp3) {
				String path = getMp3Path(mp3);
				mediaPlayer = MediaPlayer.create(Mp3PlayerActivity.this,
						Uri.parse("file://" + path));
				mediaPlayer.setLooping(false);
				mediaPlayer.start();	
				isPlay = true;
				isPause = false;
				isReleased = false;
			}
		}
	}

	class pauseLinstener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (null != mp3) {
				if (!isReleased) {
					if (!isPause) {
						mediaPlayer.pause();
						isPause = true;
						isPlay = true;
					} else {
						mediaPlayer.start();
						isPause = false;
						isPlay = true;
					}
				}
			}
		}
	}

	class stopLinstener implements OnClickListener {
		@Override
		public void onClick(View v) {
			if(null!=mp3){
				if(isPlay){
					mediaPlayer.stop();
					mediaPlayer.release();
					isReleased = true;
				}
			}

		}
	}

	private String getMp3Path(Mp3Info mp3) {
		String sdCard = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		String path = sdCard + File.separator + "mp3" + File.separator
				+ mp3.getMp3Name();
		return path;
	}
}
