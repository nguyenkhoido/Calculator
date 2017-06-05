package com.example.dknguyen.mycalculator.utils;

import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Created by dknguyen on 6/2/2017.
 */

public class Utils {

    public static void setOnclick(View v, View.OnClickListener listener) {
        if (v != null) {
            v.setOnClickListener(listener);
        }
    }

    public static void setVisibility(View v, int visiblility) {
        if (v != null) {
            v.setVisibility(visiblility);
        }
    }

    public static void setBackGround(View v, int backGroundId) {
        if (v != null) {
            v.setBackgroundResource(backGroundId);
        }
    }

    public static void setText(View tv, CharSequence cs) {
        if (tv instanceof TextView) {
            ((TextView) tv).setText(cs);
        }
    }

    public static String doubleToString(double d) {
        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');

        final DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(12);
        formatter.setDecimalFormatSymbols(symbols);
        formatter.setGroupingUsed(true);
        return formatter.format(d);
    }

    public static Double stringToDouble(String str) {
        str = str.replaceAll(",", "");
        return Double.parseDouble(str);
    }


}
