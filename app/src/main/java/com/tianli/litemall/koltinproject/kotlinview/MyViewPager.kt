package com.tianli.litemall.koltinproject.kotlinview

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class MyViewPager @JvmOverloads

constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return false
    }

}
