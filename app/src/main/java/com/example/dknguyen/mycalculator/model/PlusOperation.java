package com.example.dknguyen.mycalculator.model;

import com.example.dknguyen.mycalculator.utils.Utils;

/**
 * Created by dknguyen on 6/5/2017.
 */

public class PlusOperation {

    private double mCurrentValue;
    private double mNewValue;

    public PlusOperation(double mCurrentValue, double mNewValue) {
        this.mCurrentValue = mCurrentValue;
        this.mNewValue = mNewValue;
    }

    public double getResult() {
        return mCurrentValue + mNewValue;
    }
}
