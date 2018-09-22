package com.tianli.litemall.koltinproject

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tianli.litemall.koltinproject.bean.*
import com.tianli.litemall.koltinproject.kotlinextend.IWish
import com.tianli.litemall.koltinproject.kotlinextend.ParentWish
import com.tianli.litemall.koltinproject.kotlinextend.SonWish

class MainActivity : AppCompatActivity() {

    val a: Int? = 1
    val b: Int? = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //loop循环
        val numRange = 1 .. 16
        for (i in numRange) {
            LogUtils.showLog(i.toString())
        }
        val parentWashMachine = ParentWish()
        parentWashMachine.wish()

        runKoltin()

    }

    //Unit是返回值 可以不写
     fun runKoltin():Unit{
        //参数也是 需要申明可空和非可空
        val washMachine = WashMachine("Haier", 1)
        WashMachine.startPrintln()
        washMachine.openDoor()

        val koltinJava = KoltinJava("name",123)
        koltinJava.name
        koltinJava.age
        LogUtils.showLog(koltinJava.name+koltinJava.age+WashMachine.name+WashMachine.number)

         Week.星期一.ordinal//枚举类型中的哪个元素
         Week.星期一.name

        SingleCase.instance
        var parentWish= SonWish
        var house = listOf<IWish>(parentWish)


        var singleCase = Single
        var sss = Single


    }

    inline fun <reified t> getClassName(): String? {
        return T::class.simpleName
    }
}
