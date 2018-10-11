package com.tianli.litemall.koltinproject.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.concurrent.locks.Lock

open class KotlinView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        with(paint){
            color = Color.BLACK
            strokeWidth = 1.0f
            textSize = 18.0f
            isAntiAlias = true
        }

        apply {

        }

        read(1,0,0)

        //比如这里会调用内联函数
        innerMethod(1)


    }

    /**
     * 内敛函数
     * 降低使用高阶函数 所带来的一些运行时候的效率损失
     *
     *
     *
     */
    inline fun <T> T.apply(block:T.()->Unit):T{
        block()
        return this
    }

    /**
     * kotlin支持函数中的默认值，不用再因为一个默认值再写一个重载方法
     */
    fun read(int: Int,start: Int = 0,end: Int,content:String = "这是内容部分数据"):String{

        return ""
    }

    /**
     * 内敛函数
     * Java方法会在调用处创建一个对象，然后给该方法分配栈内存空间
     *
     * 内联函数的做法就是在编译时期就把内容替换到调用方，这样就会减少方法
     * 压栈出栈，减少资源的消耗
     */
    inline fun <T> innerMethod(t:T): T {
       return t
    }



}