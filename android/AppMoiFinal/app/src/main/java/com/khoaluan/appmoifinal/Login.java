package com.khoaluan.appmoifinal;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Login extends AppCompatActivity {

    private Toolbar toolbar;
    Button login;
    ProgressDialog dialog=null;
    HttpPost httpPost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpClient;
    List<NameValuePair> nameValuePairs;
    EditText user,pass;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        login=(Button) findViewById(R.id.bLogin);
        user=(EditText) findViewById(R.id.etUser);
        pass=(EditText) findViewById(R.id.etPass);
        tv=(TextView) findViewById(R.id.tv);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/carlsberg.ttf");
        tv.setTypeface(font);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog=ProgressDialog.show(Login.this,"","Loading...",true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        login();
                    }
                }).start();

            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    void login(){
        try{

            httpClient=new DefaultHttpClient();
            httpPost= new HttpPost("http://phongkham2.freevnn.com/khoaluan/check.php");
            nameValuePairs = new ArrayList<NameValuePair>(2);
            //for posting android side and php side variables should be similar
            nameValuePairs.add(new BasicNameValuePair("username",user.getText().toString().trim()));
            nameValuePairs.add(new BasicNameValuePair("password",pass.getText().toString().trim()));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            //Execute HTTP Post Request
            response=httpClient.execute(httpPost);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            final String response = httpClient.execute(httpPost, responseHandler);
            System.out.println("Response : " + response);

            runOnUiThread(new Runnable() {
                public void run() {
                    dialog.dismiss();
                }
            });

            if(response.equalsIgnoreCase("User Found")){
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(Login.this, "Đăng Nhập Thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(Login.this,Home.class));

            }else{
                showAlert();
            }

        }catch(Exception e){
            dialog.dismiss();
            System.out.println("Exception : " + e.getMessage());
        }
    }
    public void showAlert(){
        Login.this.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                builder.setTitle("Lỗi kết nối.");
                builder.setMessage("Không tìm thấy người dùng")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
