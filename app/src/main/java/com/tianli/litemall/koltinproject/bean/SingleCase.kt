package com.tianli.litemall.koltinproject.bean

 class SingleCase private constructor() {

     //单例
    private object Holder { val INSTANCE = SingleCase () }

    companion object {
        val instance: SingleCase by lazy { Holder.INSTANCE }
    }
    var b:String? = null
}
