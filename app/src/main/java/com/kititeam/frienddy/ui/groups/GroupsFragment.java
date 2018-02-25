package com.kititeam.frienddy.ui.groups;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.callbacks.AdapterCallback;
import com.kititeam.frienddy.fragments.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Thien on 2/23/2018.
 */

public class GroupsFragment extends BaseFragment implements AdapterCallback {
    @BindView(R.id.rvGroup)
    RecyclerView rvGroup;

    private GroupsAdapter adapter;
    private ArrayList<Group> list = new ArrayList<>();

    public GroupsFragment() {
    }

    @Override
    public void initUI() {
        setRvGroupAdapter();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.fragment_groups;
    }

    private void setRvGroupAdapter() {
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        list.add(new Group());
        adapter = new GroupsAdapter(context, list, this);
        if (rvGroup == null){
            Log.d(TAG, "setRvGroupAdapter: null");
            return;
        }
        rvGroup.setLayoutManager(new GridLayoutManager(context, 2));
        rvGroup.setAdapter(adapter);
    }


    @Override
    public void adapterCallback(int processId, Object data, int position) {

    }

}
