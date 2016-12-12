package com.khoaluan.appmoifinal;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements HomeAdapter.ClickListener {

    private Toolbar toolbar;
    private NavigationDrawerFragment mNavigationDrawerFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >=21) {
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.transistion);
            getWindow().setExitTransition(transition);
            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setReenterTransition(slide);
        }
        setContentView(R.layout.home);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeAdapter adapter = new HomeAdapter(getData(),getApplicationContext());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    public static List<Data> getData(){
        List<Data> data=new ArrayList<>();
        int[] icons={R.drawable.address,R.drawable.information,R.drawable.result1,R.drawable.deadline};
        String[] titles={"Chi Nhánh","Danh Sách","Kết Quả Lâm sàn","Thời Gian Khám Bệnh"};
        for (int i=0;i<icons.length && i<titles.length;i++){
            Data current=new Data();
            current.title=icons[i];
            current.name=titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClicked(View view, int position) {
        if(position==0){
            ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(Home.this, null);
            Intent intent=new Intent(Home.this,Chi_Nhanh.class);
            startActivity(intent,compat.toBundle());
        }else if(position==1){
            ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(Home.this, null);
            Intent intent=new Intent(Home.this,DanhSach.class);
            startActivity(intent,compat.toBundle());
        }else if(position==2){
            ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(Home.this, null);
            Intent intent=new Intent(Home.this,KetQuaXetNghiem.class);
            startActivity(intent,compat.toBundle());
        }else if(position==3){
            ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(Home.this, null);
            Intent intent=new Intent(Home.this,ThoiGianKhamBenh.class);
            startActivity(intent,compat.toBundle());
        }
    }
}
