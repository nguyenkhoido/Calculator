package com.example.dknguyen.mycalculator.presenter;

import android.text.format.Formatter;

import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.constant.Constant;
import com.example.dknguyen.mycalculator.utils.Utils;

/**
 * Created by dknguyen on 6/2/2017.
 */

public class Calculator {
    private CalculatorInterface mCalculatorInterface;
    private PlusOperation mPlusOperation;
    private String mDisplayedValue;
    private String mDisplayedFormula;
    private String mLastKey;
    private String mLastOperation;
    private boolean mResetValue;
    private boolean mIsFirstOperation;
    private double mFirstValue;
    private double mSecondValue;

    public Calculator(CalculatorInterface calculatorInterface) {
        mCalculatorInterface = calculatorInterface;
        resetValues();
        setValue("0");
        setResult("");
    }

    private void resetValues() {
        mFirstValue = 0;
        mSecondValue = 0;
        mResetValue = false;
        mLastKey = "";
        mLastOperation = "";
        mDisplayedValue = "";
        mDisplayedFormula = "";
        mIsFirstOperation = true;
    }

    private void setValue(String value) {
        mCalculatorInterface.setValue(value);
        mDisplayedValue = value;
    }

    private void setResult(String value) {
        mCalculatorInterface.setResult(value);
        mDisplayedFormula = value;
    }

    public String getDisplayedValue() {
        return mDisplayedValue;
    }

    private double getDisplayedValueAsDouble() {
        return Utils.stringToDouble(getDisplayedValue());
    }

    private void updateResult(double value) {
        setValue(Utils.doubleToString(value));
        mSecondValue = value;
    }

    private String formatString(String str) {
        if (str.contains("."))
            return str;

        final double doubleValue = Utils.stringToDouble(str);
        return Utils.doubleToString(doubleValue);
    }

    public void addDigit(int number) {
        //Why this variable need to be final ?
        String currentValue = getDisplayedValue();
        String newValue = formatString(currentValue + number);
        setValue(newValue);
    }

    public void decimalClicked() {
        String value = getDisplayedValue();
        if (!value.contains("."))
            value += ".";
        setValue(value);
    }

    public void zeroClicked() {
        String value = getDisplayedValue();
        if (!value.equals("0"))
            addDigit(0);
    }

    public void keyboardClicked(int id) {
        if (mLastKey.equals(Constant.EQUALS))
            mLastOperation = Constant.EQUALS;
        mLastKey = Constant.DIGIT;
        clear();
        switch (id) {
            case R.id.btnReset:
                mResetValue = true;
                reset();
                break;
            case R.id.btnDecimal:
                decimalClicked();
                break;
            case R.id.btn0:
                zeroClicked();
                break;
            case R.id.btn1:
                addDigit(1);
                break;
            case R.id.btn2:
                addDigit(2);
                break;
            case R.id.btn3:
                addDigit(3);
                break;
            case R.id.btn4:
                addDigit(4);
                break;
            case R.id.btn5:
                addDigit(5);
                break;
            case R.id.btn6:
                addDigit(6);
                break;
            case R.id.btn7:
                addDigit(7);
                break;
            case R.id.btn8:
                addDigit(8);
                break;
            case R.id.btn9:
                addDigit(9);
                break;
            default:
                break;
        }
    }

    //Display formula on screen
    private void updateFormula() {
        String firstValue = Utils.doubleToString(mFirstValue);
        String operation = getOperation(mLastOperation);
        String secondValue = Utils.doubleToString(mSecondValue);

        setResult(firstValue + operation + secondValue);
    }

    private String getOperation(String operation) {
        switch (operation) {
            case Constant.PLUS:
                return "+";

        }
        return "";
    }

    //Operation logic
    public void plusOperation() {
        mPlusOperation = new PlusOperation(mFirstValue, mSecondValue);
        if (mPlusOperation != null) {
            mDisplayedValue = Utils.doubleToString(mPlusOperation.getResult());
            updateResult(mPlusOperation.getResult());
        }
    }

    public void miniusOperation() {
    }

    public void multipleOperation() {
    }

    public void divideOperation() {
    }

    //Operation logic end.
    public void handleOperation(String operation) {
        if (mLastKey.equals(Constant.DIGIT))
            handleResult();

        mResetValue = true;
        mLastKey = operation;
        mLastOperation = operation;
    }

    private void handleResult() {
        mFirstValue = getDisplayedValueAsDouble();
        calculateResult();
        mSecondValue = getDisplayedValueAsDouble();
    }

    public void calculateResult() {
        if (!mIsFirstOperation) {
            updateFormula();
        }
        switch (mLastOperation) {
            case Constant.PLUS:
                plusOperation();
                break;
        }
        mIsFirstOperation = false;
    }

    public void clear() {
        if (mResetValue) {
            mDisplayedValue = "0";
        }
        mResetValue = false;
    }

    public void reset() {
        resetValues();
        setValue("0");
        setResult("");
    }
}
