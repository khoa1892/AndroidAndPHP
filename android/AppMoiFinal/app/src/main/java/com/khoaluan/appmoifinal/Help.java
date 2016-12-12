package com.khoaluan.appmoifinal;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        tv=(TextView) findViewById(R.id.tv);
        Typeface font=Typeface.createFromAsset(getAssets(),"fonts/carlsberg.ttf");
        tv.setTypeface(font);
    }
}
