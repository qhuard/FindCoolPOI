package com.example.findcoolpoi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		ListFrag startFragment = new ListFrag();
		
		transaction.add(R.id.fragment_placeholder, startFragment);
		transaction.commit();
	}
	
	public void onSelectFragment(View view) {
		
		Fragment newFragment = null;
		
		switch(view.getId()){
		case(R.id.bList):
			newFragment = new ListFrag();
			break;
		case(R.id.bMap):
			newFragment = new MapFrag();
			break;
		case(R.id.bDetails):
			newFragment = new DetailsFrag();
			break;
		};
		
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragment_placeholder, newFragment);
		transaction.addToBackStack(null);
		transaction.commit();
		
	}
}
