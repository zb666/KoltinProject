package com.tianli.litemall.koltinproject.kotlinview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import java.time.format.DecimalStyle

class EraseView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : ViewGroup(context, attrs, defStyle) {

    private lateinit var mPaint: Paint

    init {
        initView()
    }

    private fun initView() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        with(mPaint) {
            this!!.color = android.graphics.Color.BLACK
            strokeWidth = 10f
            textSize = 5f
            style = android.graphics.Paint.Style.FILL_AND_STROKE
            strokeJoin = android.graphics.Paint.Join.BEVEL
            isUnderlineText = true
            typeface = android.graphics.Typeface.DEFAULT_BOLD
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }


}