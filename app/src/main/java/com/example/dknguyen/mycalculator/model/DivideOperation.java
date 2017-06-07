package com.example.dknguyen.mycalculator.model;

import android.content.Context;

import com.example.dknguyen.mycalculator.utils.Utils;

/**
 * Created by dknguyen on 6/5/2017.
 */

public class DivideOperation {

    private double mCurrentValue;
    private double mNewValue;
    private Context mContext;

    public DivideOperation(double mCurrentValue, double mNewValue, Context mContext) {
        this.mCurrentValue = mCurrentValue;
        this.mNewValue = mNewValue;
        this.mContext = mContext;
    }

    public double getResult() {
        double result = 0;
        if (mNewValue != 0)
            result = mCurrentValue / mNewValue;
        else
            Utils.createToast(mContext);
        return result;
    }
}
