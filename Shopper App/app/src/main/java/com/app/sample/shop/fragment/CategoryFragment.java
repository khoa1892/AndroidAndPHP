package com.app.sample.shop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.app.sample.shop.R;
import com.app.sample.shop.adapter.ItemGridAdapter;
import com.app.sample.shop.data.Constant;
import com.app.sample.shop.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    public static String TAG_CATEGORY = "com.app.sample.shop.tagCategory";

    private View view;
    private RecyclerView recyclerView;
    private ItemGridAdapter mAdapter;
    private LinearLayout lyt_notfound;
    private String category = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, null);
        category = getArguments().getString(TAG_CATEGORY);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        lyt_notfound = (LinearLayout) view.findViewById(R.id.lyt_notfound);
        LinearLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //set data and list adapter
        List<ItemModel> items = new ArrayList<>();
        if(category.equals(getString(R.string.menu_clothing))){
            items = Constant.getItemClothes(getActivity());
        }else if(category.equals(getString(R.string.menu_shoes))){
            items = Constant.getItemShoes(getActivity());
        }else if(category.equals(getString(R.string.menu_watches))){
            items = Constant.getItemWatches(getActivity());
        }else if(category.equals(getString(R.string.menu_accessories))){
            items = Constant.getItemAccessories(getActivity());
        }else if(category.equals(getString(R.string.menu_bags))){
            items = Constant.getItemBags(getActivity());
        }else if(category.equals(getString(R.string.menu_new))){
            items = Constant.getItemNew(getActivity());
        }
        mAdapter = new ItemGridAdapter(getActivity(), items);
        recyclerView.setAdapter(mAdapter);
        if(mAdapter.getItemCount()==0){
            lyt_notfound.setVisibility(View.VISIBLE);
        }else{
            lyt_notfound.setVisibility(View.GONE);
        }
        return view;
    }


}
