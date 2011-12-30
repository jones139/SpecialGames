package uk.org.maps3.petsapp;


import android.os.Bundle;

public class PetsAppActivity extends PetsActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}