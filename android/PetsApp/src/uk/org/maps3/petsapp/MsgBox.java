package uk.org.maps3.petsapp;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

public class MsgBox extends Activity {
	   public static void msgBox(String message, Context context){
			Toast toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
			toast.show();
		    }

}
