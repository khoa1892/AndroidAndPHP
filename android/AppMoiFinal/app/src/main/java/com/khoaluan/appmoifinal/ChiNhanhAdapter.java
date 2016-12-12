package com.khoaluan.appmoifinal;

/**
 * Created by khoa on 6/16/2015.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by khoa on 5/21/2015.
 */
public class ChiNhanhAdapter extends RecyclerView.Adapter<ChiNhanhAdapter.pViewHolder>{

    List<Info_ChiNhanh> data= Collections.emptyList();
    private ClickListener clickListener;
    private Context context;

    public ChiNhanhAdapter(List<Info_ChiNhanh> data){
        this.data=data;
    }

    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    @Override
    public ChiNhanhAdapter.pViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        pViewHolder vh= new pViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(pViewHolder holder, int i) {

        holder.textView.setText(data.get(i).text);
        holder.imageView.setImageResource(data.get(i).image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class pViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private ImageView imageView;

        public pViewHolder(View itemView) {
            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.textView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
