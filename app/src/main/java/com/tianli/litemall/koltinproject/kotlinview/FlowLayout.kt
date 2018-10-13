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

        LogUtils.showLog("width " + widthMeasureSpec + "height " + heightMeasureSpec);

        var finalHieght = 0
        var finalWidth = 0

        val childCount = childCount
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            //measure之后就可以获取到自己的尺寸了
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)

//            val marginLayoutParams = childView.layoutParams as MarginLayoutParams
//            val topMargin = marginLayoutParams.topMargin

            val childHeight = childView.measuredHeight
            val childWidth = childView.measuredWidth

            finalWidth = Math.max(finalWidth, childWidth)

            finalHieght += childHeight
        }
        //EXACTLY  当开发者指定确切的数值之后，我们不能够再进行更改 1来不建议我们进行更改 2来测量的销量会比较高 match 拿来就用 wrap 需要自己再次进行计算

        setMeasuredDimension(if (widthMode == View.MeasureSpec.EXACTLY) widthSize else finalWidth, if (heightMode == View.MeasureSpec.EXACTLY) heightSize else finalHieght)

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
