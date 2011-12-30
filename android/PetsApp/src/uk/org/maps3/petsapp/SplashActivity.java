/**
 * 
 */
package uk.org.maps3.petsapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

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
        
        h.postDelayed(startMainActivity, 2000);
    }
}
