package com.example.dknguyen.mycalculator.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.dknguyen.mycalculator.R;

/**
 * Created by dknguyen on 7/13/2017.
 */

public class BaseFragment extends Fragment {

    public void goToAnotherFrag(FragmentManager fragmentManager, Fragment newFragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_container, newFragment, newFragment.toString());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
