package model.sqlite;
//enlaces interesantes
//http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
//http://www.vogella.com/tutorials/AndroidSQLite/article.html
//http://es.wikieducator.org/Usuario:ManuelRomero/Android/BBDD

//Android import
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

//Java import
import java.lang.reflect.Field;
import java.util.ArrayList;
////Internal import
import model.sqlite.AuxTableScreme;
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
      SQLiteDatabase db =null;
      try{
          String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)";
          db = this.getWritableDatabase();
          db.execSQL(CREATE_CONTACTS_TABLE);
          db.close();
      }catch (Exception e) {
         Log.e("---Make Table Exception-----", e.getMessage().toString()+"-------------------------------");
          db.close();
      }
  }

    /**
     * Add a Table with the Colums definit in the ArrayList,
     * @param the name of the table and a ArrayList
     * @param Every element of the ArrayList has three Strings: the colum Name, the type of the value ejm:(INTEGER, TEXT,..)and the default value
     */
    public void makeTable(String name, ArrayList<AuxTableScreme> columns){
        SQLiteDatabase db =null;
        try
        {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + name + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)";
        db = this.getWritableDatabase();
        db.execSQL(CREATE_CONTACTS_TABLE);
         for(int c=0; c < columns.size(); c++){
             AuxTableScreme column=columns.get(c);
             addColum(name, column.columName, column.type, column.value);}
            db.close();
        }catch (Exception e) {
            Log.e("---Make Table Exception-----", e.getMessage().toString()+"-------------------------------");
            db.close();
        }
    }

// Inspect is a method That Creates a table from a class
 // If the class contains arrays or lists , Then the colum name will be className_attributeName and the type integer
 // And if not there, It build the asociation table .
 public static <T> void inspect(Class<T> klazz) {
     try
     {
     Field[] fields = klazz.getDeclaredFields();
     //Log.d("-----TEXT----------","%d fields:%n", fields.length);
     for (Field field : fields) {
         // Log.d("%s %s %s%n---------", Modifier.toString(field.getModifiers()));
         Log.d("%s %s %s%n----------", field.getType().getSimpleName());
         Log.d("%s %s %s%n----------", field.getName());
         Log.d("\n----------", "--------------------------------------");}
     }catch (Exception e) {
         Log.e("---Show Columns Exception-----", e.getMessage().toString()+"-------------------------------");
     }
     //relleno la primera linea de la tabla, para poder obtener con una query las columnas que se an creado
 }

/* List the existing tables in a database
public void showTables(){
//No logro implementarlo
    }*/

//List the existing columns in a table
public void showColumns(String table){
    SQLiteDatabase db =null;
    try
    {
    db = this.getReadableDatabase();
    Cursor dbCursor = db.query(table, null, null, null, null, null, null);
    String[] columnNames = dbCursor.getColumnNames();
    for (int i=0;i<columnNames.length; i++){
        Log.d("----Tabla--------",columnNames[i]);
    }
    dbCursor.close();
    db.close();
    }catch (Exception e) {
        Log.e("---Sho Columns Exception-----", e.getMessage().toString()+"-------------------------------");
        db.close();
    }

}
 //delete a table
 public void deleteTable(String table) {
     SQLiteDatabase db =null;
     try
     {
     db = this.getReadableDatabase();
     Log.d("----Se elimita la tabla:--------",table+ " --y todo su contenido");
     db.execSQL("DROP TABLE IF EXISTS " + table);
     db.close();
 }catch(Exception e) {
    Log.e("---Delete Table  Exception-----", e.getMessage().toString()+"-------------------------------");
    db.close();
     }

 }
// delete a column

    /**
     * Add a Colum to a give table
     * @param four Strings, the Table name, the colum Name, the type of the value ejme(INTEGER, TEXT,..),the default value
     */
public void addColum(String tablename,String columName, String type, String  value) {
    SQLiteDatabase db =null;
    try {
        db = this.getReadableDatabase();
        db.execSQL("ALTER TABLE " + tablename + " ADD " + columName + " " + type + " DEFAULT " + value);
        Log.d("---Colum adding to:--", columName + "--type-- " + type + "--with-default-value--" + value + "------");
        db.close();
    } catch (Exception e) {
        Log.e("---Add Colum Exception-----", e.getMessage().toString() + "-------------------------------");
db.close();
    }
}
}
