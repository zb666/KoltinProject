package com.tianli.litemall.koltinproject.decorator

open class SuperComponentCar(private val iCar: ICar) : ICar {

    //这是最核心的代码
    override fun run() {
        iCar.run()
    }

}
