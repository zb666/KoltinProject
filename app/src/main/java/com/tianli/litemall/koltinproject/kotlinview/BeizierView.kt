package com.tianli.litemall.koltinproject.kotlinview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class BeizierView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mPaint: Paint? = null

    private var mPath: Path? = Path()

    private var floatX: Float = 0f

    private var floatY: Float = 0f

    init {
        initView()
    }

    private fun initView() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        with(mPaint) {
            this!!.color = Color.RED
            strokeWidth = 4F
        }


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val action = event!!.action

        when (action) {
            MotionEvent.ACTION_DOWN -> {
                mPath!!.moveTo(event.x, event.y)
                floatX = event.x
                floatY = event.y
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                var movedX: Float = (floatX + event.x) / 2
                var movedY: Float = (floatY + event.y) / 2
                mPath!!.quadTo(floatX, floatY, movedX, movedY)
                floatX = event.x
                floatY = event.y
                invalidate()
            }
            else -> {
                //默认的一些操作
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText("blog", 0f, 200f, mPaint!!)

//        mPath!!.apply {
//            moveTo(100F, 300F)
//            quadTo(200F, 200F, 300F, 300F)
//            quadTo(400F, 400F, 500F, 300F)
//        }
//        canvas.drawPath(mPath, mPaint)
//        mPath!!.reset()

        canvas.drawPath(mPath, mPaint)



    }

}