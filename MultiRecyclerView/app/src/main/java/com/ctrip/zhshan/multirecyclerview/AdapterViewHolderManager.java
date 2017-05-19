package com.ctrip.zhshan.multirecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.delegate.AdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 16:34.
 * @email zhshan@ctrip.com
 */

public class AdapterViewHolderManager {
    private List<AdapterDelegate> delegates = new ArrayList<AdapterDelegate>();

    public void addDelegate(AdapterDelegate delegate) {
        delegates.add(delegate);
    }

    public int getItemViewType(@NonNull List items, int position) {
        if (delegates != null) {
            AdapterDelegate delegate = delegates.get(position);
            if (delegate != null) {
                return delegate.getItemViewType(items, position);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @NonNull public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        AdapterDelegate delegate = getDelegateFromViewType(ViewType);
        if (delegate != null) {
            return delegate.onCreateViewHolder(parent);
        }
        return null;
    }

    public void onBindViewHolder(@NonNull List items, int position, @NonNull RecyclerView.ViewHolder viewHolder) {
        AdapterDelegate delegate = getDelegateFromViewType(viewHolder.getItemViewType());
        if (delegate != null) {
            delegate.onBindViewHolder(items, position, viewHolder);
        }
    }

    public AdapterDelegate getDelegateFromViewType(int viewType) {
        return delegates.get(viewType);
    }
}
