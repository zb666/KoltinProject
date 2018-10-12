package com.tianli.litemall.koltinproject

import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.support.design.R.attr.layoutManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.tianli.litemall.koltinproject.activity.PopActivity
import com.tianli.litemall.koltinproject.adapter.MultipleItem
import com.tianli.litemall.koltinproject.adapter.MultipleItemQuickAdapter
import com.tianli.litemall.koltinproject.bean.*
import com.tianli.litemall.koltinproject.decorator.BaseCar
import com.tianli.litemall.koltinproject.decorator.FlyCar
import com.tianli.litemall.koltinproject.decorator.SuperComponentCar
import com.tianli.litemall.koltinproject.kotlinextend.IWish
import com.tianli.litemall.koltinproject.kotlinextend.ParentWish
import com.tianli.litemall.koltinproject.kotlinextend.SonWish
import com.tianli.litemall.koltinproject.kotlinshare.kotlinSta
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val a: Int? = 1
    val b: Int? = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityIntent = Intent(this, PopActivity::class.java)

        startActivity(activityIntent)

        //loop循环
        val numRange = 1..16

        for (i in numRange) {
            kotlinSta.sA()
        }

        for (i in numRange) {
            LogUtils.showLog(i.toString())
        }

        val parentWashMachine = ParentWish()
        parentWashMachine.wish()

        runKoltin()

        val baseCar = BaseCar()
        //这是载体
        val superComponentCar = SuperComponentCar(baseCar)
        val flyCar = FlyCar(superComponentCar)
        flyCar.run()

        startActivity(Intent(this, PopActivity::class.java))

    }

    //Unit是返回值 可以不写
    fun runKoltin(): Unit {
        //参数也是 需要申明可空和非可空
        val washMachine = WashMachine("Haier", 1)
        WashMachine.startPrintln()
        washMachine.openDoor()

        val koltinJava = KoltinJava("name", 123)
        koltinJava.name
        koltinJava.age
        LogUtils.showLog(koltinJava.name + koltinJava.age + WashMachine.name + WashMachine.number)

        Week.星期一.ordinal//枚举类型中的哪个元素
        Week.星期一.name

        SingleCase.instance
        val parentWish = SonWish
        var house = listOf<IWish>(parentWish)


        var singleCase = Single
        var sss = Single

        val third = house?.get(0) ?: null;

    }

    inline fun <reified t> getClassName(): String? {
        return T::class.simpleName
    }
}
