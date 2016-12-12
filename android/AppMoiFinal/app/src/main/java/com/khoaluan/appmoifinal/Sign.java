package com.khoaluan.appmoifinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
import org.apache.http.cookie.CookieIdentityComparator;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Sign extends AppCompatActivity {

    private Toolbar toolbar;
    Button sign;
    EditText etUser,etPass,etPhone,etAddress,etEmail;
    String user,pass,phone,address,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        etUser=(EditText) findViewById(R.id.etUser);
        etPass=(EditText) findViewById(R.id.etPass);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etAddress=(EditText) findViewById(R.id.etAddress);
        etEmail=(EditText) findViewById(R.id.etEmail);
        sign=(Button) findViewById(R.id.bSign);
        sign.setOnClickListener(new View.OnClickListener() {
            InputStream is=null;
            @Override
            public void onClick(View v) {
                if(validation()==true) {
                    String user = "" + etUser.getText().toString();
                    String pass = "" + etPass.getText().toString();
                    String phone = "" + etPhone.getText().toString();
                    String address = "" + etAddress.getText().toString();
                    String email = "" + etEmail.getText().toString();
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("username", user));
                    nameValuePairs.add(new BasicNameValuePair("password", pass));
                    nameValuePairs.add(new BasicNameValuePair("phone", phone));
                    nameValuePairs.add(new BasicNameValuePair("address", address));
                    nameValuePairs.add(new BasicNameValuePair("email", email));
                    try {
                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://phongkham2.freevnn.com/khoaluan/insert.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        HttpResponse response = httpClient.execute(httpPost);
                        HttpEntity entity = response.getEntity();
                        is = entity.getContent();
                        String msg = "Đăng kí thành công";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    } catch (ClientProtocolException e) {
                        Log.e("Client Protocol", "Log_tag");
                        e.printStackTrace();
                    } catch (IOException e) {
                        Log.e("Log_tag", "IOE");
                        e.printStackTrace();
                    }
                }
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean  validation(){
        boolean values=true;
        if (etUser.getText().toString().length()==0 || etPhone.getText().toString().length()==0 || etPass.getText().toString().length()==0 || etEmail.getText().toString().length()==0 || etAddress.getText().toString().length()==0){
            String msg="Nhập đầy đủ thông tin";
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            values=false;
        }
        return values;
    }
}
