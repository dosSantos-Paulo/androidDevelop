package com.dossantosp.lab24

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment()  {

    lateinit var mudarTabListener: IMudarTab


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        btn_principal_mainActivity.setOnClickListener {
            mudarTabListener.mudarTab(SIGNUP_FRAGMENT)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mudarTabListener = context as IMudarTab
    }

}