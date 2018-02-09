package com.ctrip.zhshan.multirecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.AdapterViewHolderManager;
import com.ctrip.zhshan.multirecyclerview.delegate.SuperDelegate;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 17:23.
 * @email zhshan@ctrip.com
 */

public class MainAdapter extends RecyclerView.Adapter {
    private AdapterViewHolderManager manager;

    public MainAdapter(List<SuperDelegate> delegates) {
        manager = new AdapterViewHolderManager();
        manager.setDelegates(delegates);
    }

    //刷新某个Delegate
    public void updatePositionDelegate(int position) {
        manager.setItemRenderEnable(position);
        notifyItemChanged(position);
    }

    //刷新某一范围内Delegate
    public void updateRangeDelegates(int position, int size) {
        manager.setRangeRenderEnable(position, size);
        notifyItemRangeChanged(position, size);
    }

    //刷新全部Delegate
    public void updateTotalDelegates() {
        manager.setRangeRenderEnable(0, manager.getItemCount());
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return manager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        return manager.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        manager.onBindViewHolder(position, holder);
    }

    @Override
    public int getItemCount() {
        return manager.getItemCount();
    }
}
