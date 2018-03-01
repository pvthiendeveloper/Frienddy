package com.kititeam.frienddy.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.adapters.ViewPagerAdapter;
import com.kititeam.frienddy.ui.friends.FriendsFragment;
import com.kititeam.frienddy.ui.groups.GroupsFragment;
import com.kititeam.frienddy.ui.schedules.SchedulesFragment;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements SpaceOnClickListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.vpMain)
    ViewPager vpMain;
    @BindView(R.id.spaceNavigationView)
    SpaceNavigationView spaceNavigationView;

    private ViewPagerAdapter viewPagerAdapter;
    private GroupsFragment groupsFragment;
    private SchedulesFragment schedulesFragment;
    private FriendsFragment friendsFragment;
    private int menuRes = -1;


    @Override
    public void initUI() {
        menuRes = R.menu.menu_groups;
        invalidateOptionsMenu();

        setUpViewPager();
        setupSpaseNavigationView();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
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
        viewPagerAdapter.addFragment(friendsFragment);
//        viewPagerAdapter.addFragment(schedulesFragment);
        vpMain.setAdapter(viewPagerAdapter);
        vpMain.addOnPageChangeListener(this);
    }

    private void setupSpaseNavigationView(){
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_home_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.ic_group_black_24dp));
        spaceNavigationView.showIconOnly();
        spaceNavigationView.setSpaceOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuRes != -1) getMenuInflater().inflate(menuRes, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCentreButtonClick() {

    }

    @Override
    public void onItemClick(int itemIndex, String itemName) {
        switch (itemIndex){
            case 0:
                vpMain.setCurrentItem(0);
                menuRes = R.menu.menu_groups;
                invalidateOptionsMenu();
                break;
            case 1:
                vpMain.setCurrentItem(1);
                menuRes = -1;
                invalidateOptionsMenu();
                break;
        }
    }

    @Override
    public void onItemReselected(int itemIndex, String itemName) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        spaceNavigationView.changeCurrentItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
