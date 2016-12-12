package com.khoaluan.appmoifinal;

/**
 * Created by khoa on 6/16/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

public class VivzAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    List<information> data= Collections.emptyList();
    private Context context;
    private  static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;
    private ClickListener clickListener;
    public VivzAdapter(Context context,List<information> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    public void delete(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEADER){

            View view=inflater.inflate(R.layout.drawer_header,parent,false);
            HeaderHolder holder= new HeaderHolder(view);
            return holder;
        }else{

            View view=inflater.inflate(R.layout.custom_row,parent,false);
            MyViewHolder holder=new MyViewHolder(view);
            return holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_HEADER;
        }else{
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  HeaderHolder){

        }else{
            MyViewHolder myViewHolder=(MyViewHolder) holder;
            information current=data.get(position-1);
            myViewHolder.title.setText(current.title);
            myViewHolder.icon.setImageResource(current.iconId);
        }


    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
        }
        @Override
        public void onClick(View v){
            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition()-1);
            }
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder{

        TextView user,email;

        public HeaderHolder(View itemView) {
            super(itemView);
            this.user=(TextView) itemView.findViewById(R.id.txtUser);
            this.email=(TextView) itemView.findViewById(R.id.txtEmail);
            new GetAllCustomerTask().execute(new ApiConnector());

        }
        public void setTextToTextView(JSONArray jsonArray)
        {
            String s  = "";
            String f="";
            for(int i=0; i<jsonArray.length();i++){

                JSONObject json = null;
                try {
                    json = jsonArray.getJSONObject(i);
                    s = s + json.getString("username");
                    f=f+json.getString("email");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            this.user.setText(s);
            this.email.setText(f);

        }


        private class GetAllCustomerTask extends AsyncTask<ApiConnector,Long,JSONArray>
        {
            @Override
            protected JSONArray doInBackground(ApiConnector... params) {

                // it is executed on Background thread

                return params[0].GetAllCustomers();
            }

            @Override
            protected void onPostExecute(JSONArray jsonArray) {

                setTextToTextView(jsonArray);


            }
        }
    }
    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
