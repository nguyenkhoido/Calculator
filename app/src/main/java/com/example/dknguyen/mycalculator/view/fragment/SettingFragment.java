package com.example.dknguyen.mycalculator.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.adapter.AdapterSetting;
import com.example.dknguyen.mycalculator.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dknguyen on 7/13/2017.
 */

public class SettingFragment extends BaseFragment {

    private AdapterSetting mAdaptetSetting;
    private RecyclerView mRecyclerView;
    private List<String> arrString;

    private void initData(View view) {
        mRecyclerView = view.findViewById(R.id.list_Item);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        arrString = new ArrayList<>();
        arrString.add("FRANCE");
        arrString.add("FRANCE");
        arrString.add("USA");
        arrString.add("FRANCE");
        arrString.add("USA");
        arrString.add("FRANCE");
        mAdaptetSetting = new AdapterSetting(getActivity(), arrString);
        mRecyclerView.setAdapter(mAdaptetSetting);
        mAdaptetSetting.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("NGUYENDK", "SettingFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NGUYENDK", "SettingFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d("NGUYENDK", "SettingFragment onCreateView");
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        initData(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("NGUYENDK", "SettingFragment onViewCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("NGUYENDK", "SettingFragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("NGUYENDK", "SettingFragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("NGUYENDK", "SettingFragment onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("NGUYENDK", "SettingFragment onDestroy");
    }
}
