package com.m2m.ericsson.controller.activitys;

//android import
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.database.Cursor;


//Java import
import com.m2m.ericsson.controller.R;

import java.sql.SQLException;
import java.util.ArrayList;
////Internal import
import model.sqlite.AuxTableScreme;
import model.javaTree.Sensor;
import model.sqlite.DataBaseManager;


public class Texts extends Activity {
    //Atributtes
    DataBaseManager mSQLite=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        mSQLite=new DataBaseManager(this);
        /*mSQLite.deleteTable("Sensor_PayloadId");
        mSQLite.deleteTable("Sensor_ResourceId");
        mSQLite.deleteTable("SensorId");
        mSQLite.deleteTable("SensorSpecification");
        mSQLite.deleteTable("SensorType");
        mSQLite.deleteTable("id");
        mSQLite.deleteTable("ResourceId");
        mSQLite.deleteTable("PayloadId");

        mSQLite.deleteTable("Sensor");;*/
        //mSQLite.makeTable(Sensor.class);

       // mSQLite.showColumns("Sensor");
        //mSQLite.showColumns("Sensor_Payload");
        //mSQLite.showColumns("Sensor_Resource");
       /* mSQLite.showColumns("Sensor");
        mSQLite.showColumns("Sensor_Resource");
        mSQLite.showColumns("Sensor_Payload");
      AuxTableScreme colum1=new AuxTableScreme("AtributtoId", "String", "1");
     AuxTableScreme colum2=new AuxTableScreme("Atributto2", "String", "2");*/
     ArrayList<AuxTableScreme> auxArray=new ArrayList<AuxTableScreme>();
     mSQLite.showDefaultTables_Columns(Sensor.class, auxArray);
     /*auxArray.add(colum1);
     auxArray.add(colum2);
     mSQLite.deleteTable("aux");
     mSQLite.makeTableFilteringId("aux",auxArray);
     mSQLite.showColumns("aux");
     String Atributto1valor="11";
       String Atributto2valor="12";
        String Atributto11valor="111";
        String Atributto22valor="122";
       SQLiteDatabase db = mSQLite.getWritableDatabase();
        try{
            db.execSQL("INSERT INTO aux(AtributtoId,Atributto2) " +
                    "VALUES('" +
                   "1"+"','"+
                   "2"+
                    "') ");
            Log.d("---Valores insertados---","1,2----");
        }catch (Exception e){
            Log.d("Error insertando1 en la tabla", e.getMessage());
        }

        try{
            db.execSQL("INSERT INTO aux(AtributtoId,Atributto2) " +
                    "VALUES('" +
                    Atributto1valor+"','"+
                    Atributto2valor+
                    "') ");
            Log.d("---Valores insertados--", Atributto1valor+" ,"+ Atributto2valor+"-----");
        }catch (Exception e){
            Log.d("Error insertando2 en la tabla",e.getMessage());
        }
        try{
            db.execSQL("INSERT INTO aux(AtributtoId,Atributto2) " +
                    "VALUES('" +
                    Atributto11valor+"','"+
                    Atributto22valor+
                    "') ");
            Log.d("---Valores insertados--", Atributto11valor+" ,"+ Atributto22valor+"-----");
        }catch (Exception e){
            Log.d("Error insertando2 en la tabla",e.getMessage());
        }
        String[] arguments=new String[1];
        arguments[0]="0";
        Cursor aux = db.rawQuery("Select * from aux where id >= ?",arguments);
        int filas=aux.getCount();
        int columnas=aux.getColumnCount();
        Log.d("---filas ,columnas--", filas+" ,"+ columnas+"-----");
        aux.moveToFirst();
        for(int indexf=0; indexf <filas; indexf++){
                      for(int indexc=0; indexc <columnas; indexc++) {
                           String  s = aux.getString(indexc);
                Log.d("-valor C de--"+aux.getColumnName(indexc)+"--en indice--:"+indexc,"---es----"+ s+"------------" );
                           }
            if(!aux.isLast()){
                aux.moveToNext();}
        }
        aux.close();
        db.close();*/
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
