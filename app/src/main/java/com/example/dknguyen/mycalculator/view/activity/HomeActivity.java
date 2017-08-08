package com.example.dknguyen.mycalculator.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dknguyen.mycalculator.R;
import com.example.dknguyen.mycalculator.base.BaseActivity;
import com.example.dknguyen.mycalculator.constant.Constant;
import com.example.dknguyen.mycalculator.presenter.Calculator;
import com.example.dknguyen.mycalculator.presenter.CalculatorInterface;
import com.example.dknguyen.mycalculator.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements View.OnClickListener,
    CalculatorInterface {

  @BindView(R.id.btnEquals)
  Button btnEqual;
  @BindView(R.id.btnPlus)
  Button btnPlus;
  @BindView(R.id.btnMinus)
  Button btnMinus;
  @BindView(R.id.btnMultiply)
  Button btnMultiply;
  @BindView(R.id.btnDivide)
  Button btnDivide;
  @BindView(R.id.btnClear)
  Button btnClear;
  @BindView(R.id.btnReset)
  Button btnReset;
  @BindView(R.id.btnDecimal)
  Button btnDecimal;
  @BindView(R.id.btn0)
  Button btn0;
  @BindView(R.id.btn1)
  Button btn1;
  @BindView(R.id.btn2)
  Button btn2;
  @BindView(R.id.btn3)
  Button btn3;
  @BindView(R.id.btn4)
  Button btn4;
  @BindView(R.id.btn5)
  Button btn5;
  @BindView(R.id.btn6)
  Button btn6;
  @BindView(R.id.btn7)
  Button btn7;
  @BindView(R.id.btn8)
  Button btn8;
  @BindView(R.id.btn9)
  Button btn9;
  @BindView(R.id.result)
  TextView mResult;
  @BindView(R.id.formula)
  TextView mFormula;

  private Calculator mCalculator;

  private void initOnClick() {
    Utils.setOnclick(btnReset, this);
    Utils.setOnclick(btnClear, this);
    Utils.setOnclick(btnDecimal, this);
    Utils.setOnclick(btnPlus, this);
    Utils.setOnclick(btnMinus, this);
    Utils.setOnclick(btnMultiply, this);
    Utils.setOnclick(btnDivide, this);
    Utils.setOnclick(btnEqual, this);
    Utils.setOnclick(btn0, this);
    Utils.setOnclick(btn1, this);
    Utils.setOnclick(btn2, this);
    Utils.setOnclick(btn3, this);
    Utils.setOnclick(btn4, this);
    Utils.setOnclick(btn5, this);
    Utils.setOnclick(btn6, this);
    Utils.setOnclick(btn7, this);
    Utils.setOnclick(btn8, this);
    Utils.setOnclick(btn9, this);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    mCalculator = new Calculator(this);
    mCalculator.getDisplayedValue();
    initOnClick();
  }


  @Override
  public void onClick(View v) {
    int componentId = v.getId();
    switch (componentId) {
      case R.id.btnReset:
      case R.id.btnClear:
      case R.id.btnDecimal:
      case R.id.btn0:
      case R.id.btn1:
      case R.id.btn2:
      case R.id.btn3:
      case R.id.btn4:
      case R.id.btn5:
      case R.id.btn6:
      case R.id.btn7:
      case R.id.btn8:
      case R.id.btn9:
        mCalculator.keyboardClicked(componentId);
        break;
      case R.id.btnPlus:
        mCalculator.handleOperation(Constant.PLUS);
        break;
      case R.id.btnMinus:
        mCalculator.handleOperation(Constant.MINUS);
        break;
      case R.id.btnMultiply:
        mCalculator.handleOperation(Constant.MULTIPLY);
        break;
      case R.id.btnDivide:
        mCalculator.handleOperation(Constant.DIVIDE);
        break;
      case R.id.btnEquals:
        mCalculator.handleEqual();
        break;
      default:
        break;

    }
  }

  @Override
  public void setValue(String value) {
    mResult.setText(value);
  }

  @Override
  public void setResult(String value) {
    mFormula.setText(value);
  }

  @Override
  public void getErrorCode(boolean isFailed) {
    if (isFailed) {
      Utils.createToast(this);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    MenuItem mBtn = menu.findItem(R.id.action_setting);
    mBtn.setOnMenuItemClickListener(new OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, HostActivity.class);
        startActivity(intent);
        return false;
      }
    });
    return true;
  }
}
