/**
 * 
 */
package uk.org.maps3.petsapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author graham
 *
 */
public class MainMenuActivity extends PetsActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main_menu);
	}	
	
	public void startMouse(View view) {
		MsgBox.msgBox("startMouse", getApplicationContext());
	    startActivity(new Intent(getApplicationContext(),MouseActivity.class));
	}
	
	public void editPrefs(View view) {
		MsgBox.msgBox("editPrefs", getApplicationContext());
	    startActivity(new Intent(getApplicationContext(),PrefsActivity.class));
	}
    
	public void exitApp(View view) {
		MsgBox.msgBox("exitApp", getApplicationContext());
		// It might be bad practice to have this exit button, so may remove later.
		finish();
	}

}
