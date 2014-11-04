package model.sqlite;

//http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/

//Android import

import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.Activity;

//Java import
import java.lang.reflect.Field;

////Internal import
import com.m2m.ericsson.controller.R;
/**
 *Created by M2M_Ericcson on 03/11/2014.
 */
public class DataBaseManager extends SQLiteOpenHelper
{
 //Atributtes
 public String tableName="prueba";
 // All Static variables
 // Database Version
 private static final int DATABASE_VERSION = 1;
 // Database Name
 private static final String DATABASE_NAME = "M2M_ADD";
 // Constructor Make database
 public DataBaseManager(Context context) {
     super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }
    public DataBaseManager(Context context, String tableName) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.tableName=tableName;
    }
//Default Operation
// Creating Tables
@Override
public void onCreate(SQLiteDatabase db) {
   // These is where we need to write create table statements. This is called when database is created.
}

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//This method is called when database is upgraded like modifying the table structure, adding constraints to database etc.,
    }

//make a text table with a id
  public void makeTable(String name ){
      String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)";
      SQLiteDatabase db = this.getWritableDatabase();
      db.execSQL(CREATE_CONTACTS_TABLE);
  }

// Inspect is a method That Creates a table from a class
 // If the class contains arrays or lists , Then the colum name will be className_attributeName and the type integer
 // And if not there, It build the asociation table .
 public static <T> void inspect(Class<T> klazz) {
     Field[] fields = klazz.getDeclaredFields();
     //Log.d("-----TEXT----------","%d fields:%n", fields.length);
     for (Field field : fields) {
         // Log.d("%s %s %s%n---------", Modifier.toString(field.getModifiers()));
         Log.d("%s %s %s%n----------", field.getType().getSimpleName());
         Log.d("%s %s %s%n----------", field.getName());
         Log.d("\n----------", "--------------------------------------");
     }
 }

// List the existing tables in a database
    public void Show(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dbCursor = db.query(tableName, null, null, null, null, null, null);
        String[] columnNames = dbCursor.getColumnNames();
        for (int i=0;i<columnNames.length; i++){
            Log.d("----Tabla--------",columnNames[i]);
        }

    }

// List the existing columns in a table

 //delete a column of a table

// delete a table, given its name and the database to which it belongs




}
