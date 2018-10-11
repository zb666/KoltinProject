package com.tianli.litemall.koltinproject.kotlinbean

import android.util.Log

open class Base {
    //open才能获取到访问到父类中的函数
    open fun getData():String{
        Log.d("Bob","父类构造函数")
        return "result"
    }
}