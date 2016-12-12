package com.khoaluan.appmoifinal;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

public class Join extends AppCompatActivity {

    private Toolbar toolbar;
    EditText name,sdt;
    Button res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.join);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        name=(EditText) findViewById(R.id.etName);
        sdt=(EditText) findViewById(R.id.etPhone);
        res=(Button) findViewById(R.id.bRes);
        res.setOnClickListener(new View.OnClickListener() {
            InputStream is=null;
            @Override
            public void onClick(View v) {
                if(validation()==true){
                    String etname=""+name.getText().toString();
                    String etphone=""+sdt.getText().toString();
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("Ho_Va_Ten", etname));
                    nameValuePairs.add(new BasicNameValuePair("SDT", etphone));
                    try {
                        HttpClient httpClient = new DefaultHttpClient();
                        HttpPost httpPost = new HttpPost("http://phongkham2.freevnn.com/khoaluan/insert_Time.php");
                        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        HttpResponse response = httpClient.execute(httpPost);
                        HttpEntity entity = response.getEntity();
                        is = entity.getContent();
                        String msg = "Đăng ký thành công";
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
        if (name.getText().toString().length()==0 || sdt.getText().toString().length()==0){
            String msg="Nhập Đầy Đủ thông tin";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            values=false;
        }
        return values;
    }
}
