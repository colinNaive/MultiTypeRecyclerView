package com.ctrip.zhshan.multirecyclerview.delegate;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.R;
import com.ctrip.zhshan.multirecyclerview.model.SearchInfo;
import com.ctrip.zhshan.multirecyclerview.model.SpecialSellingInfo;

import java.util.Calendar;
import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class SpecialSellingDelegate implements AdapterDelegate {
    private LayoutInflater layoutInflater;
    private Context context;
    private Activity activity;

    public SpecialSellingDelegate(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(@NonNull List items, int position) {
        if (items.get(position) instanceof SpecialSellingInfo) {
            return position;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SpecialSellingViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_special_selling, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder) {

    }

    static class SpecialSellingViewHolder extends RecyclerView.ViewHolder {
        public SpecialSellingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
