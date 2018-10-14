package com.tianli.litemall.koltinproject.kotlinview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

import com.tianli.litemall.koltinproject.LogUtils

class FlowLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ViewGroup(context, attrs, defStyleAttr) {

    init {
        initView()
    }

    private fun initView() {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //测量的是自己
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //自己的建议类型尺寸
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)

        var finalHeight: Int = 0
        var finalWidth: Int = 0


        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            measureChild(childView,widthMeasureSpec,heightMeasureSpec)
            val measuredHeight = childView.measuredHeight
            val measuredWidth = childView.measuredWidth
            finalWidth = Math.max(finalWidth, measuredWidth)
            finalHeight += measuredHeight
//            childView.measure(widthMeasureSpec,heightMeasureSpec)
        }

        setMeasuredDimension(widthSize,finalHeight)

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        LogUtils.showLog("l t r b " + l + " " + t + "  " + "r " + r + "b " + b)
        LogUtils.showLog("getMeasureWidth() " + measuredHeight)
        var childTop = 0
        var childBottom = 0
        val childCount = childCount
        for (i in 0 until childCount) {
            val indexView = getChildAt(i)
            childBottom += indexView.measuredHeight
            indexView.layout(0, childTop, indexView.measuredWidth, childBottom)
            childTop += indexView.height
        }
    }

}
