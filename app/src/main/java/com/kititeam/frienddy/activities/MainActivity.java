package com.kititeam.frienddy.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.adapters.ViewPagerAdapter;
import com.kititeam.frienddy.ui.friends.FriendsFragment;
import com.kititeam.frienddy.ui.groups.GroupsFragment;
import com.kititeam.frienddy.ui.schedules.SchedulesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vpMain)
    ViewPager vpMain;
    @BindView(R.id.bnvMain)
    BottomNavigationView bnvMain;

    private ViewPagerAdapter viewPagerAdapter;
    private GroupsFragment groupsFragment;
    private SchedulesFragment schedulesFragment;
    private FriendsFragment friendsFragment;
    private MenuItem prevMenuItem;
    private int menuRes = -1;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vpMain.setCurrentItem(0);
                    menuRes = R.menu.menu_groups;
                    invalidateOptionsMenu();
                    return true;
                case R.id.navigation_dashboard:
                    vpMain.setCurrentItem(1);
                    menuRes = -1;
                    invalidateOptionsMenu();
                    return true;
                case R.id.navigation_notifications:
                    vpMain.setCurrentItem(2);
                    menuRes = -1;
                    invalidateOptionsMenu();
                    return true;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (prevMenuItem != null) {
                prevMenuItem.setChecked(false);
            } else {
                bnvMain.getMenu().getItem(0).setChecked(false);
            }
            bnvMain.getMenu().getItem(position).setChecked(true);
            prevMenuItem = bnvMain.getMenu().getItem(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void initUI() {
        bnvMain.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        vpMain.addOnPageChangeListener(mOnPageChangeListener);
        setUpViewPager();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    private void setUpViewPager() {
        groupsFragment = new GroupsFragment();
        schedulesFragment = new SchedulesFragment();
        friendsFragment = new FriendsFragment();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(groupsFragment);
        viewPagerAdapter.addFragment(schedulesFragment);
        viewPagerAdapter.addFragment(friendsFragment);
        vpMain.setAdapter(viewPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(menuRes, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
