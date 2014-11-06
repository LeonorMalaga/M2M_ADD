package model.sqlite;
//enlaces interesantes
//http://www.androidhive.info/2011/11/android-sqlite-database-tutorial/
//http://www.vogella.com/tutorials/AndroidSQLite/article.html
//http://es.wikieducator.org/Usuario:ManuelRomero/Android/BBDD

//Android import

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//Java import
////Internal import
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



/**Make tables from a class
 * every attribute make a column
 *If the class contains attributes of  arrays type
 * It will build a asociation table , name className_attributeName, columns:(id(INTEGER),classNameId(INTEGER),attributeName(INTEGER))
 * and the column name will be className_attributeNameId
 */
 public  <T> void makeTable(Class<T> klazz) {
     ArrayList<AuxTableScreme> columns=null;
     try  {  //obtain Table name
         String path= klazz.getName();
         StringTokenizer st = new StringTokenizer(path,".");
         List<String> pathList=new ArrayList();
         while (st.hasMoreTokens()){
             pathList.add(st.nextToken());
             }
         int index=pathList.size()-1;
          String name=pathList.get(index);
         Log.d("-----Name of TABLE TO MAKE------","----------:"+name+"--------");
      //obtain columns info
      columns=new ArrayList<AuxTableScreme>();
      Field[] fields = klazz.getDeclaredFields();
     Log.d("-----COLUMNAS----------","---------------------------------:-----------------");
     for (Field field : fields) {

         String columName=field.getName();
         if(columName.startsWith("m")){
             columName= columName.substring(1);
         }
         String type= field.getType().getSimpleName();
//is necesary add more cases like arrayList, arrays,
         Log.d("-----TYPE----------","---"+type+"--is equals List---"+(type.equalsIgnoreCase("List")));
         if(type.equalsIgnoreCase("List")){
            //if attribute type is iterable, we build a relational table
               columName=columName.replace("List","");
             String ralationalTableName=name+"_"+columName;
             String colum1=name+"Id";
             String colum2=columName+"Id";
             Log.d("-----AtTRIBUTE ----------","--- is an array , it create relational table----"+ralationalTableName+"---");
             SQLiteDatabase db =null;
             try
             {
                 String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " +ralationalTableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+colum1+" INTEGER, "+colum2+" INTEGER, UNIQUE("+colum1+", "+colum2+") ON CONFLICT REPLACE)";
                 db = getWritableDatabase();
                 db.execSQL(CREATE_CONTACTS_TABLE);
                 db.close();
             }catch (Exception e) {
                 Log.e("---Make relational Table Exception-----", e.getMessage().toString()+"-------------------------------");
                 db.close();
             }

            //parameters for build the table from of class
             columName=ralationalTableName+"Id";
             type="INTEGER";
         }
         Log.d("-----NOMBRE:----------"+columName,"---------------------TYPO:-----------------"+type+"-------------------");
         AuxTableScreme colum1=new AuxTableScreme( columName,type, "0");
         columns.add(colum1);
         }
         this.makeTableFilteringId(name,columns);
     }catch (Exception e) {
         Log.e("---Show Columns Exception-----", e.getMessage().toString()+"-------------------------------");
     }

     }
     //relleno la primera linea de la tabla, para poder obtener con una query las columnas que se an creado

/* List the existing tables in a database
public void showTables(){
//No logro implementarlo
    }*/

    /*List the existing  tables -->No funciona
    public void showTables(){
        Log.d("----Show Tables --------",this.getDatabaseName());
        SQLiteDatabase db =null;

            Cursor c = db.rawQuery(" SELECT name FROM M2M_ADD.sqlite_temp_master " + " WHERE type='table' ", null);
            c.moveToFirst();
            if (!c.isLast()) {
                while ( !c.isAfterLast() ) {
                    Log.d("----tabla----",c.getString(0));
                    c.moveToNext();
                }
            }
                     db.close();
                     c.close();
         }
*/List the existing columns in a table
public void showColumns(String table){
    Log.d("----Show Columns of--------",table);
    SQLiteDatabase db =null;
    try
    {
    db = this.getReadableDatabase();
    Cursor dbCursor = db.query(table, null, null, null, null, null, null);
    String[] columnNames = dbCursor.getColumnNames();
    for (int i=0;i<columnNames.length; i++){
        Log.d("----colum--------",columnNames[i]);
    }
    dbCursor.close();
    db.close();
    }catch (Exception e) {
        Log.e("---Show Columns Exception-----", e.getMessage().toString()+"-------------------------------");
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
    /**
     * Add a Table with the Colums definit in the ArrayList,
     * @param the name of the table and a ArrayList
     * @param Every element of the ArrayList has three Strings: the colum Name, the type of the value ejm:(INTEGER, TEXT,..)and the default value
     * If the name of the colum finix with "Id", this method make the column value unique
     */
    public void makeTableFilteringId(String name, ArrayList<AuxTableScreme> columns){
        SQLiteDatabase db =null;
        try
        {
            String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + name + " (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL";
            for(int c=0; c < columns.size(); c++){
                AuxTableScreme column=columns.get(c);
                String columName=column.columName;
                String type="TEXT";
                String value=null;
                /*Datatypes In SQLite Version 3
                 * NULL. The value is a NULL value.
                 *INTEGER. The value is a signed integer, stored in 1, 2, 3, 4, 6, or 8 bytes depending on the magnitude of the value.
                 *REAL. The value is a floating point value, stored as an 8-byte IEEE floating point number.
                 *TEXT. The value is a text string, stored using the database encoding (UTF-8, UTF-16BE or UTF-16LE).
                 *BLOB.
                 */
                if(column.type!="String"){
                    Log.e("---INFORMACION-----",type +"--to homogenize all parameters are converted to text--");
                    value=column.value.toString();
                }else{
                    value=column.value;
                }

                String aux=null;
                if(columName.endsWith("Id")){
                 // AN identifier can be INTEGER OR TEXT
                 if(column.type=="INTEGER"){type="INTEGER";}
                aux=CREATE_CONTACTS_TABLE+", "+columName+" "+type+ " not null unique";
                }else{
                aux=CREATE_CONTACTS_TABLE+", "+columName+" "+type+ " DEFAULT " + value;
                }
                CREATE_CONTACTS_TABLE=aux;
                }

            String aux=CREATE_CONTACTS_TABLE+")";
            CREATE_CONTACTS_TABLE=aux;
            Log.e("---A Ejecutar-----",CREATE_CONTACTS_TABLE +"-------------------------------");
            db = this.getWritableDatabase();
            db.execSQL(CREATE_CONTACTS_TABLE);
            db.close();
        }catch (Exception e) {
            Log.e("---Make Table Exception-----", e.getMessage().toString()+"-------------------------------");
            db.close();
        }
    }
    /**
     * Add a Colum to a give table
     * @param four Strings, the Table name, the colum Name, the type of the value ejme(INTEGER, TEXT,..),the default value
     * If the name of the colum finix with "Id", this method make the column value unique
     */
    public void addColumFilteringId(String tablename,String columName, String type, String  value) {
        SQLiteDatabase db =null;
        try {
            db = this.getReadableDatabase();
            if(columName.endsWith("Id")){
                db.execSQL("ALTER TABLE " + tablename + " ADD " + columName + " " + type + " not null unique");
                Log.d("---Colum adding to:--", columName + "--type-- " + type + "--with--value--Unique---");
            }else{
                db.execSQL("ALTER TABLE " + tablename + " ADD " + columName + " " + type + " DEFAULT " + value);
                Log.d("---Colum adding to:--", columName + "--type-- " + type + "--with-default-value--" + value + "------");
            }

            db.close();
        } catch (Exception e) {
            Log.e("---Add Colum Exception-----", e.getMessage().toString() + "-------------------------------");
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
