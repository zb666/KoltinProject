package com.tianli.litemall.koltinproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.tianli.litemall.koltinproject.R
import com.tianli.litemall.koltinproject.fragment.AFragment
import com.tianli.litemall.koltinproject.fragment.BFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_proxy.*

class ProxyActivity : AppCompatActivity(), AFragment.IPA, BFragment.IPB, View.OnClickListener {

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var mFB: BFragment? = null
    private var mFA: AFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxy)

        tvSelf.setOnClickListener(this)
        tvRight.setOnClickListener(this)
        mFA = AFragment()
        mFB = BFragment()

    }

    override fun onAClick() {
        //刷新B
        mFB!!.executeB("strFromA")
    }

    override fun onBClick() {
        mFA!!.executeA("strFromB")
    }
}
