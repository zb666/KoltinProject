package com.tianli.litemall.koltinproject

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tianli.litemall.koltinproject.kotlinbean.Base
import com.tianli.litemall.koltinproject.kotlinbean.IBase
import com.tianli.litemall.koltinproject.view.KotlinView

class MainActivity : AppCompatActivity(), IBase<String> {

    override fun getIBase(): String {
        return "default"
    }

    val a: Int? = 1

    val b: Int? = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    inline fun <reified t> getClassName(): String? {
        return T::class.simpleName
    }
}
