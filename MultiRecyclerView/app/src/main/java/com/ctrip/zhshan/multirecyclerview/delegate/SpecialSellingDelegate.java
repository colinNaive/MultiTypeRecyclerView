package com.ctrip.zhshan.multirecyclerview.delegate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.R;
import com.ctrip.zhshan.multirecyclerview.ViewHolderType;
import com.ctrip.zhshan.multirecyclerview.model.SpecialSellingInfo;

/**
 * @author Zhenhua on 2017/5/9 16:42.
 * @email zhshan@ctrip.com
 */

public class SpecialSellingDelegate extends SuperDelegate {
    private LayoutInflater layoutInflater;
    private Context context;
    private SpecialSellingInfo specialSellingInfo;

    public SpecialSellingDelegate(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setSpecialSellingInfo(SpecialSellingInfo specialSellingInfo) {
        this.specialSellingInfo = specialSellingInfo;
    }

    @Override
    public ViewHolderType getViewHolderType() {
        return ViewHolderType.SpecialSelling;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SpecialSellingViewHolder(layoutInflater.inflate(R.layout.cttour_independent_travel_special_selling, parent, false));
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

    static class SpecialSellingViewHolder extends RecyclerView.ViewHolder {
        public SpecialSellingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
