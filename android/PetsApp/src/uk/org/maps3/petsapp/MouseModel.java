/**
 * 
 */
package uk.org.maps3.petsapp;

import java.util.ArrayList;

/**
 * @author graham
 *
 */
public class MouseModel {
	public float xPos = 0.0f;  // Position
	public float yPos = 0.0f;
	public float zPos = 0.0f;
	public float xVel = 0.0f;  // Velocity
	public float yVel = 0.0f;
	public float zVel = 0.0f;
	public float xRot = 0.0f;  // Rotation
	public float yRot = 0.0f;
	public float zRot = 0.0f;

	public float xRot_target = 0.0f;  // Target rotation if we are turning.
	public float yRot_target = 0.0f;
	public float zRot_target = 0.0f;

	public float stepLen = 1.0f;   // The length of one step (= cycle through step keyframes)
	public Mode mode;
	
	ArrayList<TDModel> standFrames = new ArrayList<TDModel>();
	ArrayList<TDModel> walkFrames = new ArrayList<TDModel>();
	ArrayList<TDModel> lookLFrames = new ArrayList<TDModel>();
	ArrayList<TDModel> lookRFrames = new ArrayList<TDModel>();
	ArrayList<TDModel> peckFrames = new ArrayList<TDModel>();
	
	private enum Mode {STAND, WALK, LOOK_L, LOOK_R, PECK};
	
	
	public Mode getMode() {
		return mode;
	}
	
	public void startWalk() {
		mode = Mode.WALK;
	}
	
	public void stopWalk() {
		mode = Mode.STAND;
	}

	public void turnX(float xR) {
		xRot_target = xR;
	}
	public void turnY(float yR) {
		yRot_target = yR;
	}
	public void turnZ(float zR) {
		zRot_target = zR;
	}
	
	public void lookL() {
		mode = Mode.LOOK_L;
	}
	
	public void lookR() {
		mode = Mode.LOOK_R;
	}
}
