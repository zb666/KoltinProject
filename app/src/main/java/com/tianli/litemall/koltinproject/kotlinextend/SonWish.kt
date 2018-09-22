package com.tianli.litemall.koltinproject.kotlinextend

import com.tianli.litemall.koltinproject.LogUtils

//单例的调用方法 用类名 SonWish.doSomeThing() 即可
object SonWish : IWish {
    override fun wish() {
        LogUtils.showLog("son wish")
    }
}