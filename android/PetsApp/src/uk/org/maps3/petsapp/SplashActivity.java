/**
 * 
 */
package uk.org.maps3.petsapp;


import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * @author graham
 *
 */
public class SplashActivity extends PetsActivity {

	private Handler h = new Handler();
	private Runnable startMainActivity = new Runnable() {
		   public void run() {
			   Context context = getApplicationContext();
		        MsgBox.msgBox("startMainActivity Called",context);
		        startActivity(new Intent(getApplicationContext(),MainMenuActivity.class));
		       
		};
	};
			
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
        Context context = getApplicationContext();
        SharedPreferences settings = getSharedPreferences("PetsPrefs",MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        String prefTest = settings.getString("test", "default value");
        MsgBox.msgBox("prefTest="+prefTest,context);
        prefEditor.putString("test", "prefTest");
        prefEditor.commit();
        prefTest = settings.getString("test", "default value");
        MsgBox.msgBox("prefTest="+prefTest,context);
        
        Log.d("SplashActivity","Calling loadModel");
        loadModel();
        Intent mmIntent = new Intent(getApplicationContext(),
        			MainMenuActivity.class);
        Bundle b = new Bundle(); 
        //b.p
        //b.putString("name", txt1.getText().toString());
           
        //Add the set of extended data to the intent and start it
        mmIntent.putExtras(b);
        startActivity(mmIntent);  
        //startActivity(new Intent(getApplicationContext(),
        //			MainMenuActivity.class));
        
        //h.postDelayed(startMainActivity, 2000);
    }
    
    private void loadModel() {
        Log.d("loadModel","getting Assets");

    	AssetManager assetManager = getAssets();
        Log.d("loadModel","Listing Files...");
        OBJParser parser = new OBJParser();
        
    	String[] fileList;
    	String assetPath = "duckModel/walk";
    	try {
    		fileList = assetManager.list(assetPath);
            Log.d("loadModel","number of assets = "+fileList.length);

        	for (int i = 0; i<fileList.length; i++) {
        		String assetFname = assetPath+"/"+fileList[i];
        		Log.d("loadModel",fileList[i]);
        		InputStream ip = assetManager.open(assetFname);
        		mouseModel.walkFrames.add(parser.parseOBJ(ip));
        		Log.d("LoadModel","walkFrames.size()="+mouseModel.walkFrames.size());
        	}
        	} catch (IOException e) {
    		Log.e("LoadModel","Error listing walk assets");
    		
    	}
    }
}
