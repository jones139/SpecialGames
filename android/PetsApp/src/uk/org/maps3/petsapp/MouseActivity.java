package uk.org.maps3.petsapp;

import android.os.Bundle;

public class MouseActivity extends PetsActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MouseView(getApplicationContext()));
	
	}
	
	public MouseActivity() {
		// TODO Auto-generated constructor stub
	}

}
