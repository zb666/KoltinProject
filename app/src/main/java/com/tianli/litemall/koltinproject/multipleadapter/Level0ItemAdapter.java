package com.tianli.litemall.koltinproject.multipleadapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tianli.litemall.koltinproject.R;

import java.util.List;

public class Level0ItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {

    public static int TYPE_LEVEL_0 = 0;

    public static int TYPE_LEVEL_1 = 1;

    private boolean lv0 = false;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public Level0ItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_level_zero);
        addItemType(TYPE_LEVEL_1, R.layout.item_level_one);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        int itemViewType = helper.getItemViewType();
        switch (itemViewType) {
            case 0:
                //一级菜单
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int adapterPosition = helper.getAdapterPosition();
                        collapse(adapterPosition);
                    }
                });
                break;
            case 1:
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int adapterPosition = helper.getAdapterPosition();
                        Log.d("Bob","level two的位置 "+adapterPosition+"");
                    }
                });
                break;
        }
    }
}
