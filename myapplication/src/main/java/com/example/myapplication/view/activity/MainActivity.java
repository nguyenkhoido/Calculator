package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.model.CalendarScene;
import com.example.myapplication.model.ConfirmFragScene;
import com.example.myapplication.model.DialogFragScene;
import com.example.myapplication.model.TutorialScene;
import com.example.myapplication.creation.Scenario;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    public ActionBarDrawerToggle toggle;
    public Toolbar mToolbar;
    private Scenario mScenario;

    public Toolbar getToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            mToolbar.setTitle("");
            if (mToolbar != null) {
                boolean hadContentDescription = TextUtils
                        .isEmpty(mToolbar.getNavigationContentDescription());
                String contentDescription = String.valueOf(
                        !hadContentDescription ? mToolbar.getNavigationContentDescription() : "Navigation Menu");
                mToolbar.setNavigationContentDescription(contentDescription);
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }

    private void initView() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, getToolbar(), 0, 0) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initFragment() {
        mScenario.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mScenario = new Scenario();
        mScenario.addScene(new ConfirmFragScene(getSupportFragmentManager(), mScenario));
        mScenario.addScene(new TutorialScene(getSupportFragmentManager(), mScenario));
        mScenario.addScene(new DialogFragScene(getSupportFragmentManager(), mScenario));
        mScenario.addScene(new TutorialScene(getSupportFragmentManager(), mScenario));
        mScenario.addScene(new CalendarScene(getSupportFragmentManager(), mScenario));
        mScenario.addScene(new ConfirmFragScene(getSupportFragmentManager(), mScenario));
        if (savedInstanceState == null) {
            displaySelectScreen(R.id.nav_item1);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_item1) {
            displaySelectScreen(R.id.nav_item1);
        } else if (id == R.id.nav_item2) {
            displaySelectScreen(R.id.nav_item2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void displaySelectScreen(int id) {
        switch (id) {
            case R.id.nav_item1:
                initFragment();
                break;
            case R.id.nav_item2:
                break;
        }
    }

    public Scenario getmScenario() {
        return mScenario;
    }
}
