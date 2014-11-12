package com.m2m.ericsson.controller.Comunication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
//java import
import com.m2m.ericsson.controller.R;

import java.net.URL;

import org.apache.commons.io.IOUtils;
import java.net.URLConnection;



/**
 * Created by paco on 07/11/2014.
 */
public class DweetIO extends Activity {
    //atributtes
    TextView mResponseText=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dweet);
        URL url=new URL("https://dweet.io/dweet/for/uniqueId1143Leo?hello=world");
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        String encoding = con.getContentEncoding();
        encoding = encoding == null ? "UTF-8" : encoding;
        String responseString = IOUtils.toString(in, encoding);
        mResponseText.setText(responseString);


    }
}
