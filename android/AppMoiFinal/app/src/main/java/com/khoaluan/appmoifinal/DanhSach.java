package com.khoaluan.appmoifinal;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.ListView;

import org.json.JSONArray;

public class DanhSach extends AppCompatActivity {

    private ListView GetAllCustomerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danh_sach);
        if(Build.VERSION.SDK_INT >=21) {
            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transistion));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.GetAllCustomerListView=(ListView) findViewById(R.id.listView);
        new GetAllCustomerTask().execute(new ApiConnector1());
    }

    public void setListAdapter(JSONArray jsonArray){
        this.GetAllCustomerListView.setAdapter(new GetAllCustomerListAdapter(jsonArray,this));
    }

    private class GetAllCustomerTask extends AsyncTask<ApiConnector1,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector1... params) {

            // it is executed on Background thread

            return params[0].GetAllCustomers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {


            setListAdapter(jsonArray);

        }
    }
}
