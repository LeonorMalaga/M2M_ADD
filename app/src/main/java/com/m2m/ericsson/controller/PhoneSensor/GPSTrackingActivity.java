package com.m2m.ericsson.controller.phoneSensor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

import com.m2m.ericsson.controller.R;

public class GPSTrackingActivity extends Activity {

    Button btnShowLocation;

    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("------------------------Estar Activity","----------------------------------------------------------------------------------------------------------");
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation_button);
        Log.d("------------------------------Botton","----------------------------------------------------------------------------------------------------------");
        // show location button click event
        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // create class object
                gps = new GPSTracker(GPSTrackingActivity.this);
               // check if GPS enabled
                if(gps.canGetLocation()){
                    Log.d("------------------------------canGet Location","---------------OK-------------------------------------------------------------------------------------------");
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    // \n is for new line
                    Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
    }
}
