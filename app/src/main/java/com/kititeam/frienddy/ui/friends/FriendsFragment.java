package com.kititeam.frienddy.ui.friends;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.fragments.BaseFragment;
import com.melnykov.fab.FloatingActionButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Thien on 2/23/2018.
 */

public class FriendsFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    public FriendsFragment() {
    }

    @Override
    public void initUI() {
        setUpFloatingActionButton();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_friends;
    }

    private void setUpFloatingActionButton() {
        fab.attachToRecyclerView(recyclerView);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {

    }
}
