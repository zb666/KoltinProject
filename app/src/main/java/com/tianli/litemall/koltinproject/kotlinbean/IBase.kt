package com.tianli.litemall.koltinproject.kotlinbean

interface IBase<out> : IBaseFile {
    fun getIBase():String
    val iBaseString: String
        get() = "牛逼啊，老铁"
    //get() = "牛逼啊，老铁"
}