package com.ctrip.zhshan.multirecyclerview.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.ViewHolderType;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:35.
 * @email zhshan@ctrip.com
 */

public abstract class SuperDelegate {
    public boolean uiFlag = false;

    public ViewHolderType type = getViewHolderType();

    public abstract ViewHolderType getViewHolderType();

    public abstract int getItemViewType(int position);

    @NonNull
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder);
}
