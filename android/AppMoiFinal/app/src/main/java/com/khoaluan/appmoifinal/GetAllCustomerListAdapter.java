package com.khoaluan.appmoifinal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by khoa on 5/27/2015.
 */
public class GetAllCustomerListAdapter extends BaseAdapter {

    private JSONArray dataArray;
    private Activity activity;

    private static LayoutInflater inflater=null;

    public GetAllCustomerListAdapter(JSONArray jsonArray,Activity a){
        this.dataArray=jsonArray;
        this.activity=a;
        inflater=(LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.dataArray.length();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ListCell cell;

        if (convertView == null){

            convertView = inflater.inflate(R.layout.get_all_customer, null);
            cell= new ListCell();
            cell.name = (TextView) convertView.findViewById(R.id.name);
            cell.date=(TextView) convertView.findViewById(R.id.date);
            cell.phone=(TextView) convertView.findViewById(R.id.phone);
            cell.stt=(TextView) convertView.findViewById(R.id.stt);
            convertView.setTag(cell);

        }else{
            cell= (ListCell) convertView.getTag();
        }
        try{
            JSONObject jsonObject = this.dataArray.getJSONObject(position);
            cell.name.setText(jsonObject.getString("Ho_Va_Ten"));
            cell.date.setText(jsonObject.getString("Nam_Sinh"));
            cell.phone.setText(jsonObject.getString("SDT"));
            cell.stt.setText(jsonObject.getString("id"));

        }catch (JSONException e){
            e.printStackTrace();
        }


        return convertView;
    }

    private class ListCell{
        private TextView name;
        private TextView date;
        private TextView phone;
        private TextView stt;
    }
}
