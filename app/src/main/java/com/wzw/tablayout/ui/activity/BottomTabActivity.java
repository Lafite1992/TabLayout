package com.wzw.tablayout.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wzw.tablayout.R;
import com.wzw.tablayout.tab.BottomTabLayout;
import com.wzw.tablayout.tab.CommonTabLayout;
import com.wzw.tablayout.ui.fragment.ContactFragment;
import com.wzw.tablayout.ui.fragment.DiscoverFragment;
import com.wzw.tablayout.ui.fragment.MessageFragment;
import com.wzw.tablayout.ui.fragment.ProfileFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Henry on 2017/3/24.
 */

public class BottomTabActivity extends AppCompatActivity implements CommonTabLayout.OnTabClickListener {
    private List<CommonTabLayout.Tab> mBottomTabs = new ArrayList<>();
    List<Fragment> mFragments = new ArrayList<>();
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);
        mViewPager = (ViewPager) findViewById(R.id.view_pager_bottom);

        final BottomTabLayout bottomTabLayout = (BottomTabLayout) findViewById(R.id.bottom_tab_layout);
        mBottomTabs.add(new CommonTabLayout.Tab(R.drawable.tab_msg_selector,R.string.bottom_tab_msg));
        mBottomTabs.add(new CommonTabLayout.Tab(R.drawable.tab_contact_selector,R.string.bottom_tab_contact));
        mBottomTabs.add(new CommonTabLayout.Tab(R.drawable.tab_discover_selector,R.string.bottom_tab_discover));
        mBottomTabs.add(new CommonTabLayout.Tab(R.drawable.tab_profile_selector,R.string.bottom_tab_profile));
        bottomTabLayout.setTab(mBottomTabs);
        bottomTabLayout.setOnTabClickListener(this);

        mFragments.add(new MessageFragment());
        mFragments.add(new ContactFragment());
        mFragments.add(new DiscoverFragment());
        mFragments.add(new ProfileFragment());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                bottomTabLayout.setTabSelected(position);
            }
        });
        mViewPager.setAdapter(adapter);

    }


    @Override
    public void onTabClick(View view, int position) {
        Toast.makeText(getApplicationContext(), getResources().
                getText(mBottomTabs.get(position).getLabelResId()),Toast.LENGTH_SHORT).show();
        mViewPager.setCurrentItem(position,true);
    }
}
