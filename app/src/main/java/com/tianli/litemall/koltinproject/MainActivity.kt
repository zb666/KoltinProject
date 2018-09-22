package com.tianli.litemall.koltinproject

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tianli.litemall.koltinproject.kotlinextend.IWish
import com.tianli.litemall.koltinproject.kotlinextend.ParentWish
import com.tianli.litemall.koltinproject.kotlinextend.SonWish

class MainActivity : AppCompatActivity() {

    val a: Int? = 1
    val b: Int? = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //申明委托模型
//        var sonWish = SonWish()
//        var parentWish = ParentWish(sonWish)
//        parentWish.wish()

        var parentWish = ParentWish()
        parentWish.wish()

    }

    inline fun <reified t> getClassName(): String? {
        return T::class.simpleName
    }
}
