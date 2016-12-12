package com.khoaluan.appmoifinal;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;

import java.lang.annotation.Target;

public class ThoiGianKhamBenh extends AppCompatActivity implements View.OnClickListener {

    CardView reminder,join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thoi_gian_kham_benh);
        if(Build.VERSION.SDK_INT >=21) {
            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transistion));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        reminder=(CardView) findViewById(R.id.reminder);
        join=(CardView) findViewById(R.id.join);
        reminder.setOnClickListener(this);
        join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reminder:
                googleCalendar();
                break;
            case R.id.join:
                Intent intent1=new Intent(ThoiGianKhamBenh.this,Join.class);
                startActivity(intent1);
                break;
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void googleCalendar() {
        long startMillis = 0;
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, startMillis);
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }
}
