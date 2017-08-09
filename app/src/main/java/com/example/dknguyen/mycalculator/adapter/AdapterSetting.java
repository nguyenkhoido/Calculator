package com.example.dknguyen.mycalculator.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dknguyen.mycalculator.R;

import java.util.List;

/**
 * Created by dknguyen on 8/9/2017.
 */

public class AdapterSetting extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = AdapterSetting.class.getName();
    private final int TYPE_USA_STRING = 0;
    private final int TYPE_FRANCE_STRING = 1;


    private Context mContext;
    private List<String> mArrayString;

    public AdapterSetting(Context mContext, List<String> mArrayString) {
        this.mContext = mContext;
        this.mArrayString = mArrayString;
    }

    @Override
    public int getItemViewType(int position) {
        if (mArrayString.get(position).equals("FRANCE")) {
            Log.d(TAG, "----> getItemViewType   TYPE_FRANCE_STRING");
            return TYPE_FRANCE_STRING;
        } else {
            Log.d(TAG, "----> getItemViewType TYPE_USA_STRING");
            return TYPE_USA_STRING;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder;
        Log.d(TAG, "----> onCreateViewHolder");
        switch (viewType) {
            case TYPE_USA_STRING:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_usa_string, null);
                viewHolder = new USAHolder(view);
                return viewHolder;
            case TYPE_FRANCE_STRING:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_france_string, null);
                viewHolder = new FranceHolder(view);
                return viewHolder;
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "----> onBindViewHolder");

        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_USA_STRING:
                USAHolder usaHolder = (USAHolder) holder;
                usaHolder.btnUSA.setText("Recycle View");
                break;
            case TYPE_FRANCE_STRING:
                FranceHolder franceHolder = (FranceHolder) holder;
                franceHolder.tvFrance.setText("FRANCE");
                franceHolder.tvUsa.setText("USA");
                break;
            default:
        }
    }

    @Override
    public int getItemCount() {
        if (mArrayString != null && mArrayString.size() != 0)
            return mArrayString.size();
        else
            return 0;
    }

    private class FranceHolder extends RecyclerView.ViewHolder {
        TextView tvFrance;
        TextView tvUsa;

        public FranceHolder(View itemView) {
            super(itemView);

            tvFrance = itemView.findViewById(R.id.tv_france);
            tvUsa = itemView.findViewById(R.id.tv_usa);
        }
    }

    private class USAHolder extends RecyclerView.ViewHolder {
        Button btnUSA;

        public USAHolder(View itemView) {
            super(itemView);

            btnUSA = itemView.findViewById(R.id.button);
        }
    }
}
