package com.kititeam.frienddy.ui.groups;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.callbacks.AdapterCallback;

import java.util.ArrayList;

/**
 * Created by Thien on 2/24/2018.
 */

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Group> list;
    private AdapterCallback adapterCallback;

    public GroupsAdapter(Context context, ArrayList<Group> list, AdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_group, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
