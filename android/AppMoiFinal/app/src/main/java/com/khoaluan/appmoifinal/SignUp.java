package com.khoaluan.appmoifinal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    Button login,sign;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        login=(Button) findViewById(R.id.bLogin);
        sign=(Button) findViewById(R.id.bSign);
        tv=(TextView) findViewById(R.id.tv);
        Typeface font=Typeface.createFromAsset(getAssets(), "fonts/carlsberg.ttf");
        tv.setTypeface(font);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Login.class));
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,Sign.class));
            }
        });
    }
}
