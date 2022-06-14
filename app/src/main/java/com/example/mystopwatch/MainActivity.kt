package com.example.mystopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.ImageView


class MainActivity : AppCompatActivity()
{

    private lateinit var chrono:Chronometer
    private  var bool:Boolean = false
    private var offset:Long = 0
    private var bss :Long = 0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chrono = findViewById<Chronometer>(R.id.chronometer)
    }

    fun startTimer(view: View)
    {
        if(bool==false) {
            chrono.base = SystemClock.elapsedRealtime() - offset
            chrono.start()
            bool = true;
        }
        else
        {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
        }
    }
    fun stopTimer(view: View)
    {
        if(bool==true) {
            chrono.stop()
            offset = SystemClock.elapsedRealtime() - chrono.base
            bool = false
        }
    }
    fun resetTimer(view: View)
    {
        chrono.base = SystemClock.elapsedRealtime()
        offset=0
        chrono.stop()
    }
}