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

    companion object {

        var number = 10
        //伴生属性  可以直接进行使用 kotlin会自动判断对象的类型
        var name = "可以直接使用的属性"

        //kotlin的静态俗称 伴生方法
        fun startPrintln(){
            LogUtils.showLog("静态方法 start Printlf")
        }
    }

}