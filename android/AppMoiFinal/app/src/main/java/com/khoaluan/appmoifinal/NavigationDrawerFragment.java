package com.khoaluan.appmoifinal;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment implements VivzAdapter.ClickListener  {

    private RecyclerView recyclerView;
    private static  final String PREF_FILE_NAME="testpref";
    public static final String KEY_USER_LEARNED_DRAWER="user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private VivzAdapter adapter;
    private boolean mUserLearnedDrawer;
    private boolean mFromSaveIntanceState;
    private View containView;

    public NavigationDrawerFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer= Boolean.valueOf(readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if(savedInstanceState!=null){
            mFromSaveIntanceState=true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView=(RecyclerView) layout.findViewById(R.id.drawerList);
        adapter=new VivzAdapter(getActivity(),getData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static List<information> getData(){
        List<information> data=new ArrayList<>();
        int[] icons={R.drawable.ic_home_grey600_24dp,R.drawable.ic_account_grey600_24dp,R.drawable.ic_settings_grey600_24dp,R.drawable.ic_help_circle_grey600_24dp,R.drawable.ic_exit_to_app_grey600_24dp};
        String[] titles={"Trang Chủ","Thông Tin Cá Nhân","Chỉnh Sửa Tài Khỏan","Giới Thiệu","Đăng Xuất"};
        for (int i=0;i<icons.length && i<titles.length;i++){
            information current=new information();
            current.iconId=icons[i];
            current.title=titles[i];
            data.add(current);
        }
        return data;
    }

    public void setUp(int fragmentId,DrawerLayout drawerLayout, final Toolbar toolbar){
        mDrawerLayout=drawerLayout;
        mDrawerToggle=new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer){
                    mUserLearnedDrawer=true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6) {
                    toolbar.setAlpha(1 - slideOffset);
                }
            }
        };
        if(!mUserLearnedDrawer && mFromSaveIntanceState){
            mDrawerLayout.openDrawer(containView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    public static void saveToPreferences(Context context,String preferenceName,String preferenceValues){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(preferenceName,preferenceValues);
        editor.apply();
    }
    public static String readFromPreferences(Context context,String preferencesName,String defaultValues) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(preferencesName, defaultValues);
    }
    @Override
    public void itemClicked(View view, int position) {
        switch (position){
            case 0:
                startActivity(new Intent(getActivity(),Home.class));
                break;
            case 1:
                startActivity(new Intent(getActivity(),Thongtincanhan.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(),Chinhsuataikhoan.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(),Help.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(),Login.class));
                break;
        }
    }
}
