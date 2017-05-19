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
import com.ctrip.zhshan.multirecyclerview.model.PopularProductInfo;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:41.
 * @email zhshan@ctrip.com
 */

public class PopularProductDelegate implements AdapterDelegate {
    private Context context;
    private LayoutInflater layoutInflater;
    private Activity activity;

    public PopularProductDelegate(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(@NonNull List items, int position) {
        if (items.get(position) instanceof PopularProductInfo) {
            return position;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new PopularProductViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_popular_product, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder) {

    }

    static class PopularProductViewHolder extends RecyclerView.ViewHolder {
        public PopularProductViewHolder(View itemView) {
            super(itemView);
        }
    }
}
