package com.ctrip.zhshan.multirecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ctrip.zhshan.multirecyclerview.adapter.MainAdapter;
import com.ctrip.zhshan.multirecyclerview.model.IIndependentTravleData;
import com.ctrip.zhshan.multirecyclerview.model.PopularProductInfo;
import com.ctrip.zhshan.multirecyclerview.model.SearchInfo;
import com.ctrip.zhshan.multirecyclerview.model.SpecialSellingInfo;
import com.ctrip.zhshan.multirecyclerview.model.TabInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<IIndependentTravleData> list;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private LinearLayoutManager layoutManager;
    public enum ItemType {
        LOCATE_SEARCH_ITEM, TAB_ITEM, SPECIAL_SELLING_ITEM, POPULAR_PRODUCT_ITEM, X_RESOURCE_ITEM
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add(new SearchInfo());
        list.add(new TabInfo());
        list.add(new SpecialSellingInfo());
        list.add(new PopularProductInfo());

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_content_container);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainAdapter(this, this, list);
        recyclerView.setAdapter(adapter);
    }
}
