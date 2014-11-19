package com.m2m.ericsson.controller.phoneSensor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.m2m.ericsson.controller.R;

import java.util.ArrayList;

public class First extends Activity {
    //-------------------attributes-------------------------//
    private boolean mbuil = false;



    //---------------------Principal Methods---------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.phone_sensor_ble);
        // Initializes Bluetooth adapter.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//----------------------Auxyliar Metodos--------------------------//

    private void setbuild(boolean value) {
        mbuil = value;
        setProgressBarIndeterminateVisibility(value);
        ((Button) this.findViewById(R.id.Build_button)).setText(value ? "Doing"
                : "Build");
    }
    //Set Scan botton

}
