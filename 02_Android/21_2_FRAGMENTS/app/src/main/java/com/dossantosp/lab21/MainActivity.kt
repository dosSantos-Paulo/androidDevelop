package com.dossantosp.lab21

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_b.*

class MainActivity : AppCompatActivity(), IActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager


        manager.beginTransaction().add(R.id.Frame_1, FragmentA())
                .commit()

        manager.beginTransaction().add(R.id.Frame_2, FragmentB())
                .commit()




    }

    @SuppressLint("SetTextI18n")
    override fun clicou(newName:String, newAge:Int) {
        if (newAge == 0) {
            txt_dizerOi.text = "Olá $newName, você nasceu este ano"
        } else if (newAge < 0) {
            txt_dizerOi.text = "Bem vindo homem do futuro"
        } else if (newAge > 0) {
            txt_dizerOi.text = "Olá $newName, você tem $newAge anos"
        }
    }
}