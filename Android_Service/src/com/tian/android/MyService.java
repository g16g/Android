package com.tian.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		System.out.println("--Service OnCreate--");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("flags = "+flags);
		System.out.println("startId = "+startId);
		System.out.println("--Service OnStartcommand--");
		return START_NOT_STICKY;
	}
	
	@Override
	public void onDestroy() {
		System.out.println("--Servive OnDestroy--");
	}
}
