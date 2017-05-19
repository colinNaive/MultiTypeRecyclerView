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
import com.ctrip.zhshan.multirecyclerview.model.TabInfo;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class TabDelegate implements AdapterDelegate {
    private Context context;
    private LayoutInflater layoutInflater;
    private Activity activity;

    public TabDelegate(Context mBase, Activity activity) {
        context = mBase;
        layoutInflater = LayoutInflater.from(context);
        this.activity = activity;
    }

    @Override
    public int getItemViewType(@NonNull List items, int position) {
        if (items.get(position) instanceof TabInfo) {
            return position;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TabViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_tab, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder) {

    }

    static class TabViewHolder extends RecyclerView.ViewHolder {

        public TabViewHolder(View itemView) {
            super(itemView);
        }
    }
}
