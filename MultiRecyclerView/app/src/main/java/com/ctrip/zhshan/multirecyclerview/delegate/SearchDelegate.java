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

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class SearchDelegate implements AdapterDelegate {
    private LayoutInflater layoutInflater;
    private Context context;
    private Activity activity;

    public SearchDelegate(Context mBase, Activity activity) {
        this.context = mBase;
        this.activity = activity;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(@NonNull List items, int position) {
        if (items.get(position) instanceof SearchInfo) {
            return position;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SearchViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder) {

    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {
        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }
}
