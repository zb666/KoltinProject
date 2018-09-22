package com.tianli.litemall.koltinproject.bean

import com.tianli.litemall.koltinproject.LogUtils

/**
 *
 */
class WashMachine(var moudle:String,var size:Int) {

    fun openDoor(){
        LogUtils.showLog("the door has been opened")
    }

    fun start(){
        LogUtils.showLog("放水")
        LogUtils.showLog("电机开始转动")
    }

}