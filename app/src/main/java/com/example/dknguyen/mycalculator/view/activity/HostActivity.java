package com.example.dknguyen.mycalculator.view.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.view.fragment.OptionFragment;
import com.example.dknguyen.mycalculator.view.fragment.SettingFragment;

public class HostActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);

        Button btnSetting = (Button) findViewById(R.id.btnSettingFrag);

        Button btnOption = (Button) findViewById(R.id.btnOptFrag);

        btnSetting.setOnClickListener(this);
        btnOption.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnOptFrag:
                OptionFragment optionFragment;
                optionFragment = new OptionFragment();
                optionFragment.goToAnotherFrag(getSupportFragmentManager(), optionFragment, OptionFragment.class.getName());
                break;

            case R.id.btnSettingFrag:
                SettingFragment settingFragment;
                settingFragment = new SettingFragment();
                settingFragment.goToAnotherFrag(getSupportFragmentManager(), settingFragment, SettingFragment.class.getName());
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack(OptionFragment.class.getName(), 0);
    }
}
