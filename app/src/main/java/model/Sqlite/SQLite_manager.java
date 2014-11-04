package model.sqlite;

import java.lang.reflect.*;
import model.javaTree.Sensor;
import android.util.Log;

/**
 *Created by M2M_Ericcson on 03/11/2014.
 */
public class SQLite_manager
{
// List the existing databases

// List the existing tables in a database


// clear a table, given its name and the database to which it belongs

// delete a database

// Inspect is a method That Creates a database from a class
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

}
