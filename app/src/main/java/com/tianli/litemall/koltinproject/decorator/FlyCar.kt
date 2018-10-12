package com.tianli.litemall.koltinproject.decorator

import com.tianli.litemall.koltinproject.LogUtils

class FlyCar(iCar: ICar) : SuperComponentCar(iCar) {

    override fun run() {
        super.run()
        LogUtils.showLog("我能飞了")
    }
}
