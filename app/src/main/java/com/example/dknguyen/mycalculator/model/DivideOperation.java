package com.example.dknguyen.mycalculator.model;

import android.content.Context;

import com.example.dknguyen.mycalculator.utils.Utils;

/**
 * Created by dknguyen on 6/5/2017.
 */

public class DivideOperation {

    private double mCurrentValue;
    private double mNewValue;

    public DivideOperation(double mCurrentValue, double mNewValue) {
        this.mCurrentValue = mCurrentValue;
        this.mNewValue = mNewValue;
    }

    public String getResult() {
        String result;
        if (mNewValue != 0)
            result = Utils.doubleToString(mCurrentValue / mNewValue);
        else
            return "N/A";
        return result;
    }
}
