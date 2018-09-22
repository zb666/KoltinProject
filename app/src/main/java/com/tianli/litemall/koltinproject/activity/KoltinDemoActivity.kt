package com.tianli.litemall.koltinproject.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.tianli.litemall.koltinproject.MainActivity
import com.tianli.litemall.koltinproject.R
import kotlinx.android.synthetic.main.koltin_demo.*
import java.util.*


class KoltinDemoActivity : AppCompatActivity(), View.OnClickListener {

    val mList: ArrayList<String> = ArrayList()

    override fun onClick(v: View?) {
        if (tvKoltin != null) {
            Glide.with(this)
                    .load("https://img3.doubanio.com//view//photo//s_ratio_poster//public//p579729551.webp")
                    .into(ivKoltin)
            mList.add("厉害了，我的哥")
            for (s in mList) {
                Log.d("Bob",s)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.koltin_demo)
        tvKoltin.setOnClickListener(this)
    }




}