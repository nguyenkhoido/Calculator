package com.example.dknguyen.mycalculator.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.base.BaseFragment;

/**
 * Created by dknguyen on 7/13/2017.
 */

public class SettingFragment extends BaseFragment {

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
    return inflater.inflate(R.layout.fragment_settings, container, false);
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
