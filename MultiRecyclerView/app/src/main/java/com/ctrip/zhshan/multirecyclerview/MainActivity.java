package com.ctrip.zhshan.multirecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ctrip.zhshan.multirecyclerview.adapter.MainAdapter;
import com.ctrip.zhshan.multirecyclerview.delegate.PopularProductDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.SearchDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.SpecialSellingDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.SuperDelegate;
import com.ctrip.zhshan.multirecyclerview.delegate.TabDelegate;
import com.ctrip.zhshan.multirecyclerview.model.PopularProductInfo;
import com.ctrip.zhshan.multirecyclerview.model.SearchInfo;
import com.ctrip.zhshan.multirecyclerview.model.SpecialSellingInfo;
import com.ctrip.zhshan.multirecyclerview.model.TabInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SuperDelegate> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.clear();
        list.add(new SearchDelegate(this));
        list.add(new TabDelegate(this));
        list.add(new SpecialSellingDelegate(this));
        list.add(new PopularProductDelegate(this));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_content_container);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    //举例：刷新某一个View模块
    private void refreshSearchView(SearchInfo searchInfo) {
        int position = getViewHolderPosition(ViewHolderType.Search);
        ((SearchDelegate) list.get(position)).setSearchInfo(searchInfo);
        adapter.updatePositionDelegate(position);
    }

    private int getViewHolderPosition(ViewHolderType type) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getViewHolderType() == type) {
                return i;
            }
        }
        return -1;
    }
}
