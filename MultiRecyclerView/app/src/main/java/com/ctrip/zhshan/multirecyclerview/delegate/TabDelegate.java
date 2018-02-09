package com.ctrip.zhshan.multirecyclerview.delegate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.R;
import com.ctrip.zhshan.multirecyclerview.ViewHolderType;
import com.ctrip.zhshan.multirecyclerview.model.TabInfo;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class TabDelegate extends SuperDelegate {
    private Context context;
    private LayoutInflater layoutInflater;
    private TabInfo tabInfo;

    public TabDelegate(Context mBase) {
        context = mBase;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setTabInfo(TabInfo tabInfo) {
        this.tabInfo = tabInfo;
    }

    @Override
    public ViewHolderType getViewHolderType() {
        return ViewHolderType.Tab;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new TabViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_tab, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        //以下代码防止View重复刷新
        if (!uiFlag) {
            return;
        }
        uiFlag = false;

        //从此处开始刷新UI
    }

    static class TabViewHolder extends RecyclerView.ViewHolder {

        public TabViewHolder(View itemView) {
            super(itemView);
        }
    }
}
