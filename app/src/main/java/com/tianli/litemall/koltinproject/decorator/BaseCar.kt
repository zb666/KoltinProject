package com.tianli.litemall.koltinproject.decorator

import com.tianli.litemall.koltinproject.LogUtils

class BaseCar : ICar {
    override fun run() {
        LogUtils.showLog("基础功能 run ")
    }
}
