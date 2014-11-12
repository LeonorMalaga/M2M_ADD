package com.m2m.ericsson.controller.comunication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
//java import
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//M2M_ADD import
import com.m2m.ericsson.controller.R;

/**
 * Created by paco on 07/11/2014.
 */
public class DweetIOGet extends Activity {
    //atributtes
    TextView mResponseText=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dweet);
        URL url=new URL("https://dweet.io:443/dweet/for/M2M_DM/");
        URLConnection urlConnection = url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        try {
            readStream(in);
        }finally {
                in.close();
            }
            String result = getStringFromInputStream(in);
            Log.d("respuesta de https://dweet.io:443/dweet/for/M2M_DM/","------"+result+"-----");
    }
}
