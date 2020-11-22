package com.dossantosp.lab21

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_a.*
import kotlinx.android.synthetic.main.fragment_a.view.*
import java.util.*

object Keyboard {

    fun show(v: View) {
        if (v.requestFocus()) {
            (v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .toggleSoftInput(
                    InputMethodManager.SHOW_IMPLICIT,
                    InputMethodManager.HIDE_IMPLICIT_ONLY
                )
        }
    }

    fun hide(v: View) {
        v.requestFocus()
        (v.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}


class FragmentA : Fragment(){

    lateinit var IActivityContract: IActivityContract
    
    var name = ""
    var age = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_a, container, false)
        Keyboard.show(view)


        view.btn_calcularFragmentA.setOnClickListener {


            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            val newName = edt_nomeFragmentA.text.toString()
            val bornYear = edt_AnoFragmentA.text.toString()


            if (newName.isNullOrEmpty()) {
                edt_nomeFragmentA.error = "Digite seu nome"
            } else if (bornYear.isNullOrEmpty()) {
                edt_AnoFragmentA.error = "Digite o ano"
            }else {
                if (bornYear.length != 4) {
                    edt_AnoFragmentA.error = "Ex: 1987"
                } else {
                    val newAge =  (currentYear.toInt() - bornYear.toInt())
                    IActivityContract.clicou(newName,newAge)
                }
            }
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        IActivityContract = context as IActivityContract

    }



}

