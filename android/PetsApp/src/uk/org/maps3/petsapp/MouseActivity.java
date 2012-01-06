package uk.org.maps3.petsapp;

import android.os.Bundle;
import android.util.Log;

public class MouseActivity extends PetsActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("MouseActivity","mouseModel.walkFrames.size()="+mouseModel.walkFrames.size());
		TDModel model = mouseModel.walkFrames.get(0);
		Log.d("MouseActivity",model.toString());

		setContentView(new MouseView(getApplicationContext(),mouseModel));
	
	}
	
	public MouseActivity() {
		// TODO Auto-generated constructor stub
	}

}
