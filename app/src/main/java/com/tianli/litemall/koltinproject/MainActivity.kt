package com.tianli.litemall.koltinproject

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tianli.litemall.koltinproject.bean.KoltinJava
import com.tianli.litemall.koltinproject.bean.WashMachine
import com.tianli.litemall.koltinproject.bean.Week
import com.tianli.litemall.koltinproject.kotlinextend.ParentWish

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

     fun runKoltin() {
        //参数也是 需要申明可空和非可空
        val washMachine = WashMachine("Haier", 1)
        washMachine.openDoor()


        val koltinJava = KoltinJava("name",123)
        koltinJava.name
        koltinJava.age
        LogUtils.showLog(koltinJava.name+koltinJava.age)

         Week.星期一.ordinal//枚举类型中的哪个元素
         Week.星期一.name


    }

    inline fun <reified t> getClassName(): String? {
        return T::class.simpleName
    }
}
