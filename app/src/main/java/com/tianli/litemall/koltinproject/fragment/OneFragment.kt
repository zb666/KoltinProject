package com.tianli.litemall.koltinproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tianli.litemall.koltinproject.R
import kotlinx.android.synthetic.main.one_fm.*

class OneFragment : Fragment() {

    //延迟初始化
    lateinit var oneString: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        oneString = arguments!!.getString("1")
        return inflater.inflate(R.layout.one_fm, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview.text = oneString
    }


}