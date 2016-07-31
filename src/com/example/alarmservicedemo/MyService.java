package com.example.alarmservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Toast.makeText(MyService.this, "I am doin my Job", 5).show();
		return super.onStartCommand(intent, flags, startId);
	}
}
