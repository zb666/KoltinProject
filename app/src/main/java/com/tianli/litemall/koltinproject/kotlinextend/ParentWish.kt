package com.tianli.litemall.koltinproject.kotlinextend

import com.tianli.litemall.koltinproject.LogUtils

//多线程并发
class ParentWish: IWish by SonWish(){

//    override fun wish() {
//        //委托的时候 默认是不进行方法重写的，如果重写了，委托方法将无效
//
//        //如果想保留之前方法的特性 ，可以这样写 SonWish().wish()
//    }

    override fun wish() {
        LogUtils.showLog("\nparent")
        SonWish().wish()
        LogUtils.showLog("这是组合输出之后的数据")
    }
}