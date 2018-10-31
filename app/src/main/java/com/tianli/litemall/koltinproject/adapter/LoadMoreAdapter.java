package com.tianli.litemall.koltinproject.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tianli.litemall.koltinproject.R;
import com.tianli.litemall.koltinproject.bean.LoadMore;

import java.util.List;

public class LoadMoreAdapter extends BaseMultiItemQuickAdapter<MultipleItem,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public LoadMoreAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(0,R.layout.item_body);
        addItemType(1,R.layout.activity_demo);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        int itemType = item.getItemType();
        switch (itemType){
            case 0:

                break;
        }
    }

}
