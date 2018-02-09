package com.ctrip.zhshan.multirecyclerview.delegate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.R;
import com.ctrip.zhshan.multirecyclerview.ViewHolderType;
import com.ctrip.zhshan.multirecyclerview.model.SearchInfo;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class SearchDelegate extends SuperDelegate {
    private LayoutInflater layoutInflater;
    private Context context;
    private SearchInfo searchInfo;

    public SearchDelegate(Context mBase) {
        this.context = mBase;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSearchInfo(SearchInfo searchInfo) {
        this.searchInfo = searchInfo;
    }

    @Override
    public ViewHolderType getViewHolderType() {
        return ViewHolderType.Search;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SearchViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_search, parent, false));
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

    static class SearchViewHolder extends RecyclerView.ViewHolder {
        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }
}
