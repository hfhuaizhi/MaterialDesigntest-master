package com.hfhuaizhi.tabtest;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolBar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ActionBar mAb;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        initViewPager();
        mAb.setHomeAsUpIndicator(R.drawable.ic_info_black_24dp);
        mAb.setDisplayHomeAsUpEnabled(true);
        initDrawer();

    }

    private void initDrawer() {
        if(mNavigationView!=null){
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    item.setCheckable(true);
                    String title = item.getTitle().toString();
                    Toast.makeText(getApplicationContext(),title,Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        List<String> titles = new ArrayList<String>();
        for (int i = 0; i <4 ; i++) {
            titles.add("哈哈"+i);
        }
        for (int i = 0; i <titles.size() ; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<Fragment>();
        for (int i = 0; i <titles.size() ; i++) {
            fragments.add(new ListFragment());
        }
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),titles,fragments);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapter);

    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAb = getSupportActionBar();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.nv_navigation);
    }
}
