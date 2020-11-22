package com.dossantosp.lab21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val red = RedFragment()
        val blue = BlueFragment()


        btn_fragmentA.setOnClickListener {
            val transation = manager.beginTransaction()
            transation.replace(R.id.FrameLayout, red)
            transation.commit()
        }

        btn_fragmentB.setOnClickListener {
            val transation = manager.beginTransaction()
            transation.replace(R.id.FrameLayout, blue)
            transation.commit()
        }


    }
}