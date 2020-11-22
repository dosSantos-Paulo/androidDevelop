package com.dossantosp.lab24

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*


class SignUpFragment : Fragment() {

    lateinit var mudarTabListener: IMudarTab


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        btn_principal_mainActivity.setOnClickListener {
            mudarTabListener.mudarTab(LOGIN_FRAGMENT)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mudarTabListener = context as IMudarTab
    }


}