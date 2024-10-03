package com.vivek.problemsolving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch{
            printNumber1()
            printNumber2()
        }
    }

    private fun printNumber2() {
        for (i in 200..300){
            println(i)
        }
    }

    private fun printNumber1() {
        for (j in 1..100){
            println(j)
        }
    }
}