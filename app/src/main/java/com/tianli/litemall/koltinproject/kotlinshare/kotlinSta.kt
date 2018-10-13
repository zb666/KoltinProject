package com.tianli.litemall.koltinproject.kotlinshare

import com.tianli.litemall.koltinproject.LogUtils

open class kotlinSta {

    val string = ""

    companion object {
        fun sA(): String {
            LogUtils.showLog("show AAA")
            return "show AAA"
        }

        fun sB() {
            LogUtils.showLog("show BBB")
        }
    }

}