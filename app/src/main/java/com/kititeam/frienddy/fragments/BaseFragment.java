package com.kititeam.frienddy.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kititeam.frienddy.R;
import com.kititeam.frienddy.callbacks.AdapterCallback;
import com.kititeam.frienddy.utils.Constants;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Thien on 2/23/2018.
 */

public abstract class BaseFragment extends Fragment implements Constants {

    protected Context context;
    Unbinder unbinder;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(getLayoutResourceId(), container, false);
        unbinder = ButterKnife.bind(this, v);
        initUI();
        context = getActivity();
        return v;
    }

    public abstract void initUI();

    public abstract int getLayoutResourceId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
