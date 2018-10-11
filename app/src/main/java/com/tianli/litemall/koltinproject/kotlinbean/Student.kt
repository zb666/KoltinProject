package com.tianli.litemall.koltinproject.kotlinbean

import android.util.Log

class Student : Base(){

    class conStudent(a:Int,str:String){
        var customerKey = str.toUpperCase()
    }

    override fun getData(): String {
        Log.d("Bob","子类构造函数")
        return super.getData()
    }

}
