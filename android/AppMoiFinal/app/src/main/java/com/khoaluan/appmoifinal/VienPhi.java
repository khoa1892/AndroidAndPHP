package com.khoaluan.appmoifinal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class VienPhi extends ActionBarActivity {

    private TextView name,kham,xetnghiem,thuoc,thutuc,tong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vien_phi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.name=(TextView) findViewById(R.id.txtname);
        this.kham=(TextView) findViewById(R.id.txtKham);
        this.xetnghiem=(TextView) findViewById(R.id.txtXet);
        this.thuoc=(TextView) findViewById(R.id.txtThuoc);
        this.thutuc=(TextView) findViewById(R.id.txtThuTuc);
        this.tong=(TextView) findViewById(R.id.txtTong);
        new GetAllCustomerTask().execute(new ApiConnector4());
    }
    public void setTextToTextView(JSONArray jsonArray) {
        String s = "";
        String f = "";
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                s = s + json.getString("Ho_Va_Ten");
                f = f + json.getString("Tien_Kham")+" "+"VND";
                a = a + json.getString("Tien_Xet_Nghiem")+" "+"VND";
                b = b + json.getString("Tien_Thuoc")+" "+"VND";
                c = c + json.getString("Thu_Tuc")+" "+"VND";
                d = d + json.getString("Tong")+" "+"VND";
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        this.name.setText(s);
        this.kham.setText(f);
        this.xetnghiem.setText(a);
        this.thuoc.setText(b);
        this.thutuc.setText(c);
        this.tong.setText(d);
    }





    private class GetAllCustomerTask extends AsyncTask<ApiConnector4,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector4... params) {

            // it is executed on Background thread

            return params[0].GetAllCustomers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {

            setTextToTextView(jsonArray);


        }
    }
}

