package com.tianli.litemall.koltinproject.kotlinview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.tianli.litemall.koltinproject.LogUtils

class ClipView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {

    private var mPath = Path()

    private val mPaint = Paint()

    init {
        with(mPaint) {
            color = Color.GREEN
            strokeWidth = 20f
            flags = Paint.ANTI_ALIAS_FLAG
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val action = event.action
          when(action) {
            MotionEvent.ACTION_MOVE -> {
                mPath.addCircle(event.x, event.y, 50f, Path.Direction.CW)
                invalidate()
                return true
            }
            else ->{
                return false
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        with(canvas) {
            drawColor(Color.GREEN)
            clipPath(mPath)
            LogUtils.showLog("绘制")
            super.onDraw(canvas)
        }
    }

}
