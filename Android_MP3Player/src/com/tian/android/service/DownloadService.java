package com.tian.android.service;

import com.tian.android.model.Mp3Info;
import com.tian.android.utils.HttpDownloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DownloadService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Mp3Info mp3Info = (Mp3Info) intent.getSerializableExtra("mp3");
		DownloadThread downloadThread = new DownloadThread(mp3Info);
		Thread thread = new Thread(downloadThread);
		thread.start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 下载线程
	 * @author tian
	 *
	 */
	class DownloadThread implements Runnable{
		private Mp3Info mp3Info = null;
		public DownloadThread(Mp3Info mp3Info){
			this.mp3Info = mp3Info;
		}
		@Override
		public void run() {
			String strUrl = "http://192.168.0.126:8080/Android_Service/"+mp3Info.getMp3Name();
			//下载操作
			int result = new HttpDownloader().download(strUrl, "mp3/", mp3Info.getMp3Name());
			System.out.println(result);
		}
	}
	

}
