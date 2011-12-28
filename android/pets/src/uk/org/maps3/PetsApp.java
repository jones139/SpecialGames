package  uk.org.maps3.pets;


import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Debug;
import android.telephony.CellLocation;

/**
 * Note:  This code is based on http://objloaderforand.sourceforge.net/.
 *
 * The initial Android Activity, setting and initiating
 * the OpenGL ES Renderer Class @see Lesson02.java
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 * @author Graham Jones
 */
public class PetsApp extends Activity {

	/** The OpenGL View */


	/**
	 * Initiate the OpenGL View and set our own
	 * Renderer (@see Lesson02.java)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Debug.startMethodTracing("calc");
		super.onCreate(savedInstanceState);
		setContentView(new MyRenderer(this));
	}

	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		Debug.stopMethodTracing();
		super.onPause();
	}
	@Override
	protected void onDestroy(){
		Debug.stopMethodTracing();
		super.onDestroy();
	}

}