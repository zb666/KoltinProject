package com.tianli.litemall.koltinproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.tianli.litemall.koltinproject.LogUtils
import com.tianli.litemall.koltinproject.R
import com.tianli.litemall.koltinproject.bean.KoltinJava
import com.tianli.litemall.koltinproject.bean.WashMachine
import kotlinx.android.synthetic.main.koltin_demo.*
import java.util.*
import kotlin.collections.ArrayList


class KoltinDemoActivity : AppCompatActivity(), View.OnClickListener {

    val mList: ArrayList<String> = ArrayList()

    override fun onClick(v: View?) {
        if (tvKoltin != null) {
            Glide.with(this).load("https://img3.doubanio.com//view//photo//s_ratio_poster//public//p579729551.webp").into(ivKoltin)
            mList.add("厉害了，我的哥")
            for (s in mList) {
                Log.d("Bob", s)
            }
        }else if (v == ivKoltin){
        }
        runKoltin()
    }

    private fun runKoltin() {
        //参数也是 需要申明可空和非可空
        val washMachine = WashMachine("Haier", 1)
        washMachine.openDoor()
        val koltinJava = KoltinJava("name",123)
        koltinJava.name
        koltinJava.age
        LogUtils.showLog(koltinJava.name+koltinJava.age)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.koltin_demo)
        tvKoltin.setOnClickListener(this)
        runKoltin()
    }


}