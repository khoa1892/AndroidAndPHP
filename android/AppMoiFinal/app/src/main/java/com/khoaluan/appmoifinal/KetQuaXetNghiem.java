package com.khoaluan.appmoifinal;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class KetQuaXetNghiem extends AppCompatActivity {

    TextView name,mau,ketqua,benhly,cao,nang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ket_qua_xet_nghiem);
        if(Build.VERSION.SDK_INT >=21) {
            Slide slide = new Slide();
            slide.setDuration(500);
            getWindow().setEnterTransition(slide);
            getWindow().setReturnTransition(TransitionInflater.from(this).inflateTransition(R.transition.transistion));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.name=(TextView) findViewById(R.id.name);
        this.mau=(TextView) findViewById(R.id.txtMau);
        this.ketqua=(TextView) findViewById(R.id.txtKetQua);
        this.benhly=(TextView) findViewById(R.id.txtBenh);
        this.cao=(TextView) findViewById(R.id.txtCao);
        this.nang=(TextView) findViewById(R.id.txtNang);
        new GetAllCustomerTask().execute(new ApiConnector2());
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
                f = f + json.getString("Nhom_mau");
                a = a + json.getString("Xet_Nghiem");
                b = b + json.getString("benh_ly");
                c = c + json.getString("Chieu_cao");
                d = d + json.getString("Can_nang");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        this.name.setText(s);
        this.mau.setText(f);
        this.ketqua.setText(a);
        this.benhly.setText(b);
        this.nang.setText(c);
        this.cao.setText(d);
    }


    private class GetAllCustomerTask extends AsyncTask<ApiConnector2,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector2... params) {

            // it is executed on Background thread

            return params[0].GetAllCustomers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {

            setTextToTextView(jsonArray);


        }
    }
}
