package com.m2m.ericsson.controller.comunication;

import android.app.Activity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.TextView;
import android.util.Log;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
//java import
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;

//M2M_ADD import
import com.m2m.ericsson.controller.R;
import com.m2m.ericsson.controller.phoneSensor.GPSTracker;
/**
 * Tarea pendiente, probar http://square.github.io/okhttp/
 * en vez de java.net.URL
 */
public class DweetIOGet extends Activity {
    //atributtes
    String mlatitude;
    String mlongitude;
    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comunication_dweet);
        //Obtener latitud y longitud de googlePlayServicesUtils
        //primero comprovar si podemos conectar a googlePlayServices
        Log.d("----------------------layoutOk------------------------------------------", "------------------------------------");
        // create class object
        gps = new GPSTracker(this);
        // check if GPS enabled
        if(gps.canGetLocation()){
            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();
            Log.d("---------------------LocationOk------------------------------------------", "------------------------------------");
            mlatitude=String.valueOf(latitude);
            mlongitude=String.valueOf(longitude);
        }
                   //mlatitude="2";
       // mlongitude="3";
        Log.d("----------------------latitud y longitud y altitude------------------------------------------", mlatitude+" y "+mlongitude+"------------------------------------");
        //  String url="https://dweet.io:443/dweet/for/M2M_DM";
        String url="https://dweet.io:443/dweet/for/M2M_DM?latitude="+mlatitude+"&longitude="+mlongitude;
        Log.d("------url-------------", url+"------------------------------------");
            new getDweetIO(url).execute();
           }

    private String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while (i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            Log.d("---Error in readStream---", e.getMessage());
            return "";
        }
    }

    private String inputStreamToString(InputStream is) {
        String line;
        StringBuilder total = new StringBuilder();
        // Wrap a BufferedReader around the InputStream
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        // Read response until the end
        try {
            while ((line = rd.readLine()) != null)
                total.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return full string
        return total.toString();
    }


    private class getDweetIO extends AsyncTask<String, Void, String> {
       URL url;
        public getDweetIO(String stringUrl) {
               try {
                url = new URL(stringUrl);
                   Log.d("----------------------UrlOk------------------------------------------", "------------------------------------");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected String doInBackground(String... params) {
            String result="Server not response";
           try{
            //url = new URL("https://dweet.io/dweet/for/M2M12345567789a?hello=world");
            URLConnection urlConnection = url.openConnection();
            Log.d("----------------------UrlConnectionOk------------------------------------------", "------------------------------------");
            InputStream in0 = urlConnection.getInputStream();
            Log.d("----------------------getInputStreamOk------------------------------------------", "------------------------------------");
            InputStreamReader in = new InputStreamReader(in0);
            Log.d("----------------------getInputStreanReaderOk------------------------------------------", "------------------------------------");
            BufferedReader rd = new BufferedReader(in);
            Log.d("----------------------BufferedOk------------------------------------------", "------------------------------------");
            String line;
            StringBuilder total = new StringBuilder();
            try {

                while ((line = rd.readLine()) != null)
                    total.append(line);            } catch (IOException e) {
                e.printStackTrace();
            }
            result = total.toString();
            Log.d("-------------------------StringOk---------------------------------------", "------------------------------------");
            Log.d("respuesta de https://dweet.io:443/dweet/for/M2M_DM/", "------" + result + "-----");

        } catch (MalformedURLException e) {
            Log.d("---Error make URL---https://dweet.io:443/dweet/for/M2M_DM/", e.getMessage());
        } catch (IOException e) {
            Log.d("---Error IOException", e.getMessage());
        }
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            TextView t = (TextView) findViewById(R.id.response_TexView);
            if(result != null) {
                t.setText(result);
            }else if(result == ""){
                t.setText("RESPONSE OK");
            }else{
                t.setText("TEST OK");
            } }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }

}