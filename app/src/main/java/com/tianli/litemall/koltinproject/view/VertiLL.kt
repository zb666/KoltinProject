package com.tianli.litemall.koltinproject.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

import com.tianli.litemall.koltinproject.R

class VertiLL @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.item_body, this)
    }
}
