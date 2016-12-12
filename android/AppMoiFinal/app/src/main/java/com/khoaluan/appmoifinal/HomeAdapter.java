package com.khoaluan.appmoifinal;

/**
 * Created by khoa on 6/16/2015.
 */
import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by khoa on 5/13/2015.
 */
public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.PersonViewHolder>{

    private List<Data> dataList;
    private ClickListener clickListener;
    private Context context;
    public HomeAdapter(List<Data> dataList,Context context){
        this.dataList=dataList;
        this.context=context;

    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener=clickListener;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected ImageView imageView;
        protected TextView text;
        PersonViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
            text=(TextView) itemView.findViewById(R.id.textView);
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
    public HomeAdapter.PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row1, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }
    public ClipData.Item currentItem;
    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.text.setText(dataList.get(i).name);
        personViewHolder.imageView.setImageResource(dataList.get(i).title);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    public interface ClickListener{
        public void itemClicked(View view, int position);
    }
}
