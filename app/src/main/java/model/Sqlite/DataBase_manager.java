package model.sqlite;



//Android import

import android.util.Log;

import com.m2m.ericsson.controller.R;

import java.lang.reflect.Field;

//Java import
////Internal import

/**
 *Created by M2M_Ericcson on 03/11/2014.
 */
public class DataBase_manager
{
 //Atributtes
 // All Static variables
 // Database Version
 private static final int DATABASE_VERSION = 1;
 // Database Name
 private static final String DATABASE_NAME = R.string.app_name;
 // Constructor Make database


// Inspect is a method That Creates a table from a class
 // If the class contains arrays or lists , Then the colum name will be className_attributeName and the type integer
 // And if not there, It build the asociation table .
 public static <T> void inspect(Class<T> klazz) {
     Field[] fields = klazz.getDeclaredFields();
     //Log.d("-----TEXT----------","%d fields:%n", fields.length);
     for (Field field : fields) {
         // Log.d("%s %s %s%n---------", Modifier.toString(field.getModifiers()));
         Log.d("%s %s %s%n----------", field.getType().getSimpleName());
         switch field.getType().getSimpleName();
         Log.d("%s %s %s%n----------", field.getName());
     }
 }
//make a text table with a id

// List the existing tables in a database

// List the existing columns in a table

 //delete a column of a table

// delete a table, given its name and the database to which it belongs




}
