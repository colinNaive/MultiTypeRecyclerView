package com.ctrip.zhshan.multirecyclerview.delegate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.R;
import com.ctrip.zhshan.multirecyclerview.ViewHolderType;
import com.ctrip.zhshan.multirecyclerview.model.PopularProductInfo;

/**
 * @author Zhenhua on 2017/5/9 16:41.
 * @email zhshan@ctrip.com
 */

public class PopularProductDelegate extends SuperDelegate {
    private Context context;
    private LayoutInflater layoutInflater;
    private PopularProductInfo popularProductInfo;

    public PopularProductDelegate(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setPopularProductInfo(PopularProductInfo popularProductInfo) {
        this.popularProductInfo = popularProductInfo;
    }

    @Override
    public ViewHolderType getViewHolderType() {
        return ViewHolderType.PopularProduct;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new PopularProductViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_popular_product, parent, false));
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

    static class PopularProductViewHolder extends RecyclerView.ViewHolder {
        public PopularProductViewHolder(View itemView) {
            super(itemView);
        }
    }
}
