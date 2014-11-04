package com.m2m.ericsson.controller;

//android import
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//Java import

//Internal import
import model.javaTree.Sensor;
import model.sqlite.DataBaseManager;


public class cover extends Activity {
    //Atributtes
    DataBaseManager mSQLite=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        mSQLite=new DataBaseManager(this);
        //mSQLite.inspect(Sensor.class);
        mSQLite.makeTable("prueba");
        mSQLite.Show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cover, menu);
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
}
