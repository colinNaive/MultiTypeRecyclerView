package com.ctrip.zhshan.multirecyclerview.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:35.
 * @email zhshan@ctrip.com
 */

public interface AdapterDelegate {
    public int getItemViewType(@NonNull List items, int position);
    @NonNull public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);
    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder holder);
}
