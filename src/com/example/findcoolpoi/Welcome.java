package com.example.findcoolpoi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Welcome extends Activity{
	
	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		ourSong = MediaPlayer.create(Welcome.this, R.raw.intro);
		ourSong.start();
		Thread timer = new Thread() {
			public void run(){
				try{
					sleep(6000);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.example.findcoolpoi.STARTINGPOINT");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
