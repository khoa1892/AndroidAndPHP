package com.khoaluan.appmoifinal;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Chinhsuataikhoan extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    Button update;
    EditText etPass,etPhone,etAddress;
    String pass,phone,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinhsuataikhoan);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        etPass=(EditText) findViewById(R.id.etPass);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etAddress=(EditText) findViewById(R.id.etAddress);
        update=(Button) findViewById(R.id.bUpdate);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        update.setOnClickListener(new View.OnClickListener() {
            InputStream is=null;
            @Override
            public void onClick(View v) {
                String pass = "" + etPass.getText().toString();
                String phone = "" + etPhone.getText().toString();
                String address = "" + etAddress.getText().toString();
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("password", pass));
                nameValuePairs.add(new BasicNameValuePair("SDT", phone));
                nameValuePairs.add(new BasicNameValuePair("Que_Quan", address));
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://phongkham2.freevnn.com/khoaluan/update.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    String msg = "Update Thành Công";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } catch (ClientProtocolException e) {
                    Log.e("Client Protocol", "Log_tag");
                    e.printStackTrace();
                } catch (IOException e) {
                    Log.e("Log_tag", "IOE");
                    e.printStackTrace();
                }
            }
        });
    }
}
