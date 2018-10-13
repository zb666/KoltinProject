package com.tianli.litemall.koltinproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

import com.tianli.litemall.koltinproject.LogUtils
import com.tianli.litemall.koltinproject.R
import com.tianli.litemall.koltinproject.adapter.MultipleItem
import com.tianli.litemall.koltinproject.adapter.MultipleItemQuickAdapter
import com.tianli.litemall.koltinproject.adapter.ViewPagerAdapter
import com.tianli.litemall.koltinproject.kotlinextend.IWish
import com.tianli.litemall.koltinproject.kotlinshare.kotlinSta
import com.tianli.litemall.koltinproject.kotlinview.VertiLL
import kotlinx.android.synthetic.main.activity_test.*

import java.util.ArrayList

class PopActivity : AppCompatActivity(), View.OnClickListener, IWish {

    override fun wish() {
        LogUtils.showLog("show things")
    }

    private var btProduce: Button? = null
    private var btConsume: Button? = null

    private val sObjLock = Any()

    private val mList = ArrayList<String>()
    private var threadA: Thread? = null
    private var threadB: Thread? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val linearLayout = findViewById<LinearLayout>(R.id.ll_container)
        btProduce = findViewById(R.id.tv_produce)
        btConsume = findViewById(R.id.tv_consume)

        btConsume!!.setOnClickListener(this)
        btProduce!!.setOnClickListener(this)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val multipleItem = MultipleItem(0)
        val list = ArrayList<MultipleItem>()
        list.add(multipleItem)
        list.add(multipleItem)
        list.add(multipleItem)
        val itemQuickAdapter = MultipleItemQuickAdapter(list)
        //        recyclerView.setAdapter(itemQuickAdapter);

        val vertiLL = VertiLL(this)

        linearLayout.addView(vertiLL)

        vertiLL.setOnClickListener {
            val sA = kotlinSta.sA()
        }

        threadA = object : Thread("A") {
            override fun run() {
                super.run()
                pop()
            }
        }
        threadB = object : Thread("B") {
            override fun run() {
                super.run()
                push()
            }
        }

        val sA = kotlinSta.sA()

        kotlinSta.sB()

        var listzb = ArrayList<String>()
        listzb.add("1")


        listzb.apply {
            add("1")
        }

        with(listzb){

            add("1")
            add("2")
                    add("")
            println("this = " + this)
        }.let {
            println()
        }

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)




        viewpager.adapter = viewPagerAdapter

        var listArray = ArrayList<String>()


        with(listArray){
            add("zhoubo666")
            add("如果黎明未出现 是因为还未到过最黑暗处")
        }

        viewPagerAdapter.setData(listArray)


    }


    fun setIWish(){

    }

    override fun onClick(v: View) {
        if (v === btConsume) {
            pop()
        } else if (v === btProduce) {
            push()
        }
    }

    private fun pop() {
        synchronized(this) {
            if (mList.size == 0) {
                try {
                    LogUtils.showLog("线程" + Thread.currentThread().name + "卡在这里了,等待数据的生产")
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
            LogUtils.showLog("线程" + Thread.currentThread().name + "被唤醒了，开始消费数据了")

            mList.removeAt(0)
        }
    }

    private fun push() {
        synchronized(this) {
            LogUtils.showLog("线程" + Thread.currentThread().name + "开始生产数据了")
            mList.add("任意的数据")
            //唤醒的是当前等待队列中的线程 并不一定是当前的线程，是根据等待队列中的线程来进行计算的
        }
    }
}
