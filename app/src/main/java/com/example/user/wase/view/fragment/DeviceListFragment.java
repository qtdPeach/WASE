package com.example.user.wase.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.wase.R;

/**
 * Created by ymbae on 2016-04-18.
 */
public class DeviceListFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_devicelist, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
