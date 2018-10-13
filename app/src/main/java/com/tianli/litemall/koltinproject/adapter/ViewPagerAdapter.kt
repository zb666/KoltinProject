package com.tianli.litemall.koltinproject.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.tianli.litemall.koltinproject.fragment.OneFragment
import com.tianli.litemall.koltinproject.fragment.TwoFragment

class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private val mArray = ArrayList<String>()

    override fun getItem(p0: Int): Fragment {
        // var result = if(a>b){a}else{b} //Kotlin中的三目运算  最后结果 8
        if (p0 == 0) {
            val oneFragment = OneFragment()
            val bundle = Bundle()
            bundle.putString("1", "OneFm")
            oneFragment.arguments = bundle
            return oneFragment
        } else {
            val twoFragment = TwoFragment()
            val twoBundle = Bundle()
            twoBundle.putString("2", "TwoFm")
            twoFragment.arguments = twoBundle
            return twoFragment
        }
    }

    override fun getCount(): Int {
        return mArray.size//To change body of created functions use File | Settings | File Templates.
    }

    open fun setData(array: java.util.ArrayList<String>) {
        mArray.clear()
        mArray.addAll(array)
        notifyDataSetChanged()
    }

}
