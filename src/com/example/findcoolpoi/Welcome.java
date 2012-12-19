package com.example.findcoolpoi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;

public class Welcome extends Activity{
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		//Lancement de la chanson d'accueil
		ourSong = MediaPlayer.create(Welcome.this, R.raw.intro);
		ourSong.start();
		new loadSomeStuff().execute();
		
		Thread timer = new Thread() {
			public void run() {
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
	
	
	//Implémentation traditionnelle de la TaskBar
	public class loadSomeStuff extends AsyncTask<String, Integer, String> {

		ProgressDialog dialog;
		
		protected void onPreExecute() {
			// example of setting up something
			dialog = new ProgressDialog(Welcome.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		
		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			for(int i = 0; i < 20; i++){
				publishProgress(5);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			return null;
		}

		protected void onProgressUpdate(Integer... progress) {
			dialog.incrementProgressBy(progress[0]);
		}

		protected void onPostExecute(String result) {
			
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
