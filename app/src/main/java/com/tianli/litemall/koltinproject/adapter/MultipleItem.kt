package com.tianli.litemall.koltinproject.adapter

import com.chad.library.adapter.base.entity.MultiItemEntity

class MultipleItem(private val mItemType: Int) : MultiItemEntity {

    override fun getItemType(): Int {
        return mItemType
    }

    companion object {

        val HEADER = 0x1

        val BODY = 0x2
    }

}
