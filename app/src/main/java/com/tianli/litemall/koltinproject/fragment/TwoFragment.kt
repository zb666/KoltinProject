package com.tianli.litemall.koltinproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tianli.litemall.koltinproject.R
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.two_fm.*

class TwoFragment : Fragment() {

    var string: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        string = arguments!!.getString("2")
        return inflater.inflate(R.layout.two_fm, null, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview.text = string
    }
}