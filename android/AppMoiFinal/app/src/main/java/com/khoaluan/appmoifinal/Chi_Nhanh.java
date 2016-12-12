package com.khoaluan.appmoifinal;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class Chi_Nhanh extends AppCompatActivity implements ChiNhanhAdapter.ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            Slide slide=new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transistion));
        }
        setContentView(R.layout.chi__nhanh);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ChiNhanhAdapter adapter= new ChiNhanhAdapter(getData());
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

    }
    public static List<Info_ChiNhanh> getData(){
        List<Info_ChiNhanh> data=new ArrayList<>();
        int[] icons={R.drawable.phone,R.drawable.location};
        String[] titles={"16515102036","1 Hoàng Hoa Thám, P6, Q.Bình Thạnh, Tp.HCM"};
        for (int i=0;i<icons.length && i<titles.length;i++){
            Info_ChiNhanh current=new Info_ChiNhanh();
            current.image=icons[i];
            current.text=titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClicked(View view, int position) {
        if (position==0){
            Intent callIntent=new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:16515102036"));
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(callIntent);
        }else if(position==1){
            String url="https://www.google.com/maps/place/Ph%C3%B2ng+Kh%C3%A1m+Vi%E1%BB%87t+M%E1%BB%B9/@10.8057775,106.6902951,17z/data=!4m5!1m2!2m1!1zMSBIb8OgbmcgSG9hIFRow6FtLCBQNiwgUS5Cw6xuaCBUaOG6oW5oLCBUcC5IQ00!3m1!1s0x317528c44f2276e5:0x9be1dd2cebdb87cf";
            Intent mapIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(mapIntent);
        }
    }
}