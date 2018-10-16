package com.tianli.litemall.koltinproject.kotlinview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class TextSelfView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mPaint: Paint? = null

    private var mPath: Path? = Path()

    init {
        initView()
    }

    private fun initView() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        with(mPaint) {
            this!!.color = Color.BLACK
            strokeWidth = 10f
            textSize = 5f
            style = Paint.Style.FILL_AND_STROKE
            strokeJoin = Paint.Join.BEVEL
            isUnderlineText = true
            typeface = Typeface.DEFAULT_BOLD
        }
        mPaint!!.setPathEffect(PathEffect())


    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("blog", 0f, 200f, mPaint!!)

        canvas.drawLine(0f, 200f, 400f, 200f, mPaint!!)

        //apply 会返回其本身的对象
        mPath!!.apply {
            moveTo(300F, 300F)
            lineTo(300F, 500F)
            lineTo(500F, 500F)
        }
        canvas.drawPath(mPath,mPaint)


    }

}
