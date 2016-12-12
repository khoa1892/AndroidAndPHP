package com.khoaluan.appmoifinal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Thongtincanhan extends AppCompatActivity {


    private NavigationDrawerFragment mNavigationDrawerFragment;
    private TextView name,gioi,date,que,phone,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongtincanhan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        this.name=(TextView) findViewById(R.id.txtName);
        this.gioi=(TextView) findViewById(R.id.txtGioi);
        this.date=(TextView) findViewById(R.id.txtSinh);
        this.que=(TextView) findViewById(R.id.txtQue);
        this.phone=(TextView) findViewById(R.id.txtPhone);
        this.email=(TextView) findViewById(R.id.txtEmail);
        new GetAllCustomerTask().execute(new ApiConnector3());
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
                f = f + json.getString("Nam_Sinh");
                a = a + json.getString("Gioi_tinh");
                b = b + json.getString("Que_Quan");
                c = c + json.getString("SDT");
                d = d + json.getString("email");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        this.name.setText(s);
        this.gioi.setText(a);
        this.date.setText(f);
        this.que.setText(b);
        this.phone.setText(c);
        this.email.setText(d);
    }



    private class GetAllCustomerTask extends AsyncTask<ApiConnector3,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector3... params) {

            // it is executed on Background thread

            return params[0].GetAllCustomers();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {

            setTextToTextView(jsonArray);


        }
    }
}