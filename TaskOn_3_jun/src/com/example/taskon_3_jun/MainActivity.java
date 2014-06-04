package com.example.taskon_3_jun;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btcam;
	Button btphn;
	Button btmusic;
	Button bt2activity;
	private MediaPlayer mp;
	Context context=this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btcam=(Button)findViewById(R.id.btncamera);
		btphn=(Button)findViewById(R.id.btnPhnbook);
		btmusic=(Button)findViewById(R.id.btnMusic);
		bt2activity=(Button)findViewById(R.id.btnActivity2);
		startCamera();
		startPhonbook();
		startMusicPlayer();
		startNextActivity();


	}
	public void startCamera()
	{
		btcam.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivity(intent);  


			}
		});

	}
	public void startPhonbook()
	{
		btphn.setOnClickListener( new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent();
				i.setComponent(new ComponentName("com.android.contacts", "com.android.contacts.DialtactsContactsEntryActivity"));
				//		    i.setAction("android.intent.action.MAIN");
				//		    i.addCategory("android.intent.category.LAUNCHER");
				//		    i.addCategory("android.intent.category.DEFAULT");
				startActivity(i);
			}

		});
	}

	public void startMusicPlayer()
	{
		btmusic.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {


				Intent intent= new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
				startActivity(intent);
			}
		});
	}


	public void startNextActivity(){
		bt2activity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent= new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intent);
			}
		});
	}

}

