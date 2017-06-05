package com.example.dknguyen.mycalculator.presenter;

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

    public double getResult() {
        double result = 0;
        if (mNewValue != 0)
            result = mCurrentValue / mNewValue;
        return result;
    }
}
