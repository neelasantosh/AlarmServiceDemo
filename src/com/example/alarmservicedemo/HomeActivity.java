package com.example.alarmservicedemo;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {
	Button buttonSetAlarm, buttonResetAlarm, buttonStatrOntime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		buttonResetAlarm = (Button) findViewById(R.id.button1);
		buttonSetAlarm = (Button) findViewById(R.id.button2);
		buttonStatrOntime = (Button) findViewById(R.id.button3);
		buttonSetAlarm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent in = new Intent(HomeActivity.this, MyService.class);
				PendingIntent pi = PendingIntent.getService(HomeActivity.this,
						0, in, PendingIntent.FLAG_UPDATE_CURRENT);

				// prepare time to execute pi
				long timeSinceBoot = SystemClock.elapsedRealtime();// in
				long timeToExecute = timeSinceBoot + 10000;
				// pass pi and time to AlarmManager
				AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
				am.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeToExecute, pi);

				// repeated alarm
				am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
						timeToExecute, 6000, pi);
			}
		});

		buttonResetAlarm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(HomeActivity.this, MyService.class);
				PendingIntent pi = PendingIntent.getService(HomeActivity.this,
						0, in, PendingIntent.FLAG_UPDATE_CURRENT);

				AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
				am.cancel(pi);
			}
		});
		
		
		buttonStatrOntime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent in = new Intent(HomeActivity.this, MyService.class);
				PendingIntent pi = PendingIntent.getService(HomeActivity.this,
						0, in, PendingIntent.FLAG_UPDATE_CURRENT);
				
				//create time to Execute
				Calendar cal = Calendar.getInstance();
				//set date
				cal.set(2105, 11, 24, 07, 30, 50);
				long timeToExecute = cal.getTimeInMillis();
				
				AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
				am.set(AlarmManager.RTC_WAKEUP, timeToExecute, pi);
				
			}
		});
	}//eof oncreate
}
