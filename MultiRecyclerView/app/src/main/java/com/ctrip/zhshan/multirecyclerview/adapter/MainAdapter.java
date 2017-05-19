package com.ctrip.zhshan.multirecyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ctrip.zhshan.multirecyclerview.AdapterViewHolderManager;
import com.ctrip.zhshan.multirecyclerview.delegate.PopularProductDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.SearchDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.SpecialSellingDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.TabDelegate;
import com.ctrip.zhshan.multirecyclerview.model.IIndependentTravleData;
import com.ctrip.zhshan.multirecyclerview.model.PopularProductInfo;
import com.ctrip.zhshan.multirecyclerview.model.SearchInfo;
import com.ctrip.zhshan.multirecyclerview.model.SpecialSellingInfo;
import com.ctrip.zhshan.multirecyclerview.model.TabInfo;

import java.util.List;

/**
 * @author Zhenhua on 2017/5/9 17:23.
 * @email zhshan@ctrip.com
 */

public class MainAdapter extends RecyclerView.Adapter {
    private AdapterViewHolderManager manager;
    private Activity activity;
    private Context context;
    private List<IIndependentTravleData> independentTravelInfoList;

    public MainAdapter(Activity activity, Context context, List<IIndependentTravleData> independentTravelInfoList) {
        this.activity = activity;
        this.context = context;
        this.independentTravelInfoList = independentTravelInfoList;

        manager = new AdapterViewHolderManager();

        if (independentTravelInfoList != null && independentTravelInfoList.size() != 0) {
            for (int i = 0; i < independentTravelInfoList.size(); i ++) {
                if (independentTravelInfoList.get(i) instanceof SearchInfo) {
                    manager.addDelegate(new SearchDelegate(context, activity));
                } else if (independentTravelInfoList.get(i) instanceof TabInfo) {
                    manager.addDelegate(new TabDelegate(context, activity));
                } else if (independentTravelInfoList.get(i) instanceof SpecialSellingInfo) {
                    manager.addDelegate(new SpecialSellingDelegate(context, activity));
                } else if (independentTravelInfoList.get(i) instanceof PopularProductInfo) {
                    manager.addDelegate(new PopularProductDelegate(context, activity));
                }
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return manager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        return manager.getItemViewType(independentTravelInfoList, position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        manager.onBindViewHolder(independentTravelInfoList, position, holder);
    }

    @Override
    public int getItemCount() {
        return independentTravelInfoList.size();
    }
}
