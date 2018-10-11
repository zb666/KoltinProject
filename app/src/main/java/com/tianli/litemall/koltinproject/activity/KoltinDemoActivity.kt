package com.tianli.litemall.koltinproject.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity.AXIS_SPECIFIED
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tianli.litemall.koltinproject.R
import com.tianli.litemall.koltinproject.kotlinbean.Base
import com.tianli.litemall.koltinproject.kotlinbean.Student
import com.tianli.litemall.koltinproject.kotlinbean.TestI
import kotlinx.android.synthetic.main.koltin_demo.*
import java.io.BufferedReader
import java.io.FileReader
import java.time.Duration
import java.util.*
import kotlin.collections.ArrayList


open class KoltinDemoActivity : AppCompatActivity(), View.OnClickListener {

    val mList: ArrayList<String> = ArrayList()

    //就是16进制下的1
    var a: Int? = AXIS_SPECIFIED

    //可以不使用
    val str = "string"

    val x = 2

    val arr = intArrayOf(1, 2, 4, 6)
    var list = ArrayList<String>()

    override fun onClick(v: View?) {
        a = null
        if (a!=null){
        }
        if (tvKoltin != null) {
            Glide.with(this)
                    .load("https://img3.doubanio.com//view//photo//s_ratio_poster//public//p579729551.webp")
                    .into(ivKoltin)

            mList.add("厉害了，我的哥")
            for (s in mList) {
                Log.d("Bob", "" + (a == 1))
            }
        }

        toast(str)

        whenMethod()

        withMethod()

        tvKoltin.setOnClickListener{

        }

        val person = Person("", 1)

        var people = listOf(Person("",1),Person("1",2))

        val maxBy = people.maxBy {
            it.age
        }

    }

    /**
     * data 关键字能够帮我们自动的生成Bean类中的一些toString(),
     * equals(),hashcode()方法 copy方法
     */
    data class Person(val name: String,val age :Int)

    /**
     * 相当于规定了一个作用域，该作用域中的方法某人都是由xx对象所调起来的
     */
    private fun withMethod() {
        val student = Student()
        with(student) {
            getData()
        }
    }

    //when 代替 if else
    private fun whenMethod() {
        when (x) {
            1 -> Log.d("Bob", "111")
            2 -> Log.d("Bob", "当前获取的数据项是222")
            else -> {
                Log.d("Bob", "其他数据项")
            }
        }
    }

    inline fun <T> with(t: T, body: T.() -> Unit) {
         t.body()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.koltin_demo)
        tvKoltin.setOnClickListener(this)
        startActivity(Intent(this,MultiAdapterActivity::class.java))
        val testI = TestI()
        tvKoltin.text = testI.iBaseString
    }

    fun Context.toast(message: CharSequence,duration: Int = Toast.LENGTH_SHORT){
        tvKoltin.isBold(tvKoltin)
        Toast.makeText(this,message,duration).show()
    }

     fun TextView.isBold(textView: TextView){
        textView.text = "这是一个属性"
    }

    fun TextView.setBold(color: Color){
        tvKoltin.text = ""
        tvKoltin.linkTextColors
    }


    /***---------------------高阶函数，类似于rxjava的操作符----------------------------------***/

    /**
     * 高阶函数 let方法
     * 接收int类型的表达式 然后使用for循环去对集合中的对象做action操作
     */
    fun methodLet(){
        arr.let {
            it.forEach {
                //it 指的就是自身
            }
        }
    }

    /**
     * fold含有折叠的意思
     * 在这里是进行求和
     */
    fun foldGetSum(){
        val fold = arr.fold(StringBuilder()) { acc, i ->
            acc.append(i).append("\n")
        }
        println(fold)
    }

    /**
     * filter 在这里是进行过滤的意思
     * 得到了新的集合数据
     */
    fun filterMethod(){
        val filteredList = arr.filter {
            it == 2 || it == 4
        }
        println(filteredList)
    }

    /**
     * 下面介绍的是类似于continue操作符的takeWhile
     */
    fun continueMethod(){
        val takeWhileList = arr.takeWhile {
            it != 2
        }
        println(takeWhileList)
    }

    //let with apply都可以进行代码的简化

    fun useMethod(){
        BufferedReader(FileReader("test.txt")).use {
            var line:String?
            while (true){
                //读到空数据的时候进行返回
                line = it.readLine()?:break
                print(line)
            }
        }
    }


    /**
     * 遇到符合条件的数据的时候
     * 就进行该项数据的获取，然后抛弃后面的数据
     */
    fun takeWhile(){
        val takeWhile = arr.takeWhile {
            it % 2 == 1
        }
    }

    /**
     * !!!这里有点特殊 Rxjava中是以1对1 进行转化的
     * 但是这里的话是进行数据的加工，然后生成新的数据类型
     */
    fun map(){
        val map = arr.map {
            it + 1
        }
    }

    /**
     *  这里是进行集合机构的剥离
     */
    fun flatMap(){
        val flatMap = list.flatMap {
            it.map {

            }
        }
    }



}