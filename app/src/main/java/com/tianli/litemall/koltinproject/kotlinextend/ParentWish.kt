package com.tianli.litemall.koltinproject.kotlinextend

import com.tianli.litemall.koltinproject.LogUtils

//多线程并发
class ParentWish : IWish by SonWish {

//    override fun wish() {
//        //委托的时候 默认是不进行方法重写的，如果重写了，委托方法将无效
//
//        //如果想保留之前方法的特性 ，可以这样写 SonWish().wish()
//    }

    var int1: Int? = 0

    fun setInt(int: Int) {
        this.int1 = int
    }

    //静态方法
    companion object {
        var number2 = 200
        fun getId():Int{
            return number2
        }
    }

    override fun wish() {
        LogUtils.showLog("\nparent")
        SonWish.wish()
        LogUtils.showLog("这是组合输出之后的数据"+ParentWish.getId())
    }

    fun plus(int1: Int, int2: Int) = int1 + int2


}