package com.app.sample.shop;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sample.shop.data.Constant;
import com.app.sample.shop.data.GlobalVariable;
import com.app.sample.shop.fragment.CartFragment;
import com.app.sample.shop.fragment.CategoryFragment;

public class ActivityMain extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private ActionBar actionBar;
    private Menu menu;
    private View parent_view;
    private GlobalVariable global;
    private NavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent_view = findViewById(R.id.main_content);
        global = (GlobalVariable) getApplication();

        setupDrawerLayout();
        initToolbar();

        // display first page
        displayView(R.id.nav_new, getString(R.string.menu_new));
        actionBar.setTitle(R.string.menu_new);

        // for system bar in lollipop
        if (Constant.getAPIVerison() >= 5.0) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        actionBar = getSupportActionBar();

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawerLayout,         /* DrawerLayout object */
                mToolbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) { super.onDrawerClosed(view); }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) { super.onDrawerOpened(drawerView); }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(mDrawerToggle);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

    }

    @Override
    protected void onResume() {
        setMenuCounter(nav_view , R.id.nav_cart, global.getCartItemTotal());
        super.onResume();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        nav_view = (NavigationView) findViewById(R.id.navigation_view);
        setMenuCounter(nav_view , R.id.nav_cart, global.getCartItemTotal());
        nav_view .setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                actionBar.setTitle(menuItem.getTitle());
                displayView(menuItem.getItemId(), menuItem.getTitle().toString());
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_cart:
                displayView(R.id.nav_cart, getString(R.string.menu_cart));
                actionBar.setTitle(R.string.menu_cart);
                break;
            case R.id.action_credit:
                Snackbar.make(parent_view, "Credit Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Snackbar.make(parent_view, "Setting Clicked", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_about: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("About");
                builder.setMessage(getString(R.string.about_text));
                builder.setNeutralButton("OK", null);
                builder.show();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayView(int id, String title) {
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setDisplayShowTitleEnabled(true);
        Fragment fragment = null;
        Bundle bundle = new Bundle();
        switch (id) {
            case R.id.nav_cart:
                fragment = new CartFragment();
                break;
            case R.id.nav_new:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            case R.id.nav_promo:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;


            //sub menu
            case R.id.nav_clothing:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            case R.id.nav_shoes:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            case R.id.nav_watches:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            case R.id.nav_accessories:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            case R.id.nav_bags:
                fragment = new CategoryFragment();
                bundle.putString(CategoryFragment.TAG_CATEGORY, title);
                break;
            default:
                break;
        }

        fragment.setArguments(bundle);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_content, fragment);
            fragmentTransaction.commit();
            //initToolbar();
        }
    }

    private long exitTime = 0;

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        doExitApp();
    }

    private void setMenuCounter(NavigationView nav, @IdRes int itemId, int count) {
        TextView view = (TextView) nav.getMenu().findItem(itemId).getActionView();
        view.setText(String.valueOf(count));
    }

}


