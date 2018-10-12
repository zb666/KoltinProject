package com.tianli.litemall.koltinproject.adapter

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tianli.litemall.koltinproject.R

class MultipleItemQuickAdapter
/**
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.
 *
 * @param data A new list is created out of this one to avoid mutable list
 */
(data: List<MultipleItem>) : BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(data) {
    init {
        addItemType(MultipleItem.HEADER, R.layout.item_header)
        addItemType(MultipleItem.BODY, R.layout.item_body)
    }

    override fun convert(helper: BaseViewHolder, item: MultipleItem) {
        helper.setText(R.id.tv_body, item.itemType.toString() + "")
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) MultipleItem.HEADER else MultipleItem.BODY
    }
}
