package com.dossantosp.lab24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.view.get
import androidx.core.widget.addTextChangedListener
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*

const val LOGIN_FRAGMENT = 0
const val SIGNUP_FRAGMENT = 1
class MainActivity : AppCompatActivity(), IMudarTab {

    val tab by lazy { findViewById<TabLayout>(R.id.tabLayout_mainActivity) }
    val page by lazy { findViewById<ViewPager>(R.id.pager_mainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = listOf(LoginFragment(), SignUpFragment())
        val titulos = listOf(getString(R.string.sign_in), getString(R.string.sign_up))




        // Deve ativar a primeira tab, caso o usuário clique antes de digitar o login
//        findViewById<Button>(R.id.btn_principal_mainActivity).setOnClickListener {
//
//            testaLogIn(this.btn_principal_mainActivity)
//        }


        tab.setupWithViewPager(page)
        page.adapter = ViewPageAdapter(fragments,titulos,supportFragmentManager)

//
//        tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab!!.position == 0){
//
//
//                    findViewById<Button>(R.id.btn_principal_mainActivity).apply {
//                        this.text = getString(R.string.log_in)
//                        this.isEnabled = true
//                    }
//
//                    testaLogIn(findViewById<Button>(R.id.btn_principal_mainActivity))
//
//
//                } else if (tab!!.position == 1){
//
//
//                    findViewById<Button>(R.id.btn_principal_mainActivity).apply {
//                        this.text = getText(R.string.sign_up)
//                        this.isEnabled = false
//                    }
//
//                    testaSignIn(findViewById<Button>(R.id.btn_principal_mainActivity))
//
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
//
//
//    }
//
//    private fun testaLogIn(principalButton: Button) {
//        val nameLogin = findViewById<TextInputLayout>(R.id.et_username_login).editText
//        val passwordLogin = findViewById<TextInputLayout>(R.id.et_senha_login).editText
//
//
//        principalButton.setOnClickListener {
//            if (nameLogin?.text.isNullOrBlank()){
//                nameLogin?.error = getString(R.string.digite_o_login)
//            } else if (passwordLogin?.text.isNullOrBlank()) {
//                passwordLogin?.error = getString(R.string.digite_a_senha)
//            } else {
//                Toast.makeText(this@MainActivity, getString(R.string.log_in), Toast.LENGTH_LONG).show()
//            }
//            nameLogin?.text?.clear()
//            passwordLogin?.text?.clear()
//        }
//    }
//
//    private fun testaSignIn(principalButton: Button) {
//
//        val checkBox = findViewById<CheckBox>(R.id.checkbox_iAgree_signUp)
//        val nameSignIn = findViewById<TextInputLayout>(R.id.et_username_signUp).editText
//        val passwordSignIn = findViewById<TextInputLayout>(R.id.et_senha_signUp).editText
//        val repeatPasswordSignIn = findViewById<TextInputLayout>(R.id.et_repeatSenha_signUp).editText
//
//        checkBox.setOnCheckedChangeListener { _, isChecked ->
//            principalButton.isEnabled = isChecked
//        }
//
//        principalButton.setOnClickListener {
//            if (nameSignIn?.text.isNullOrBlank()){
//                nameSignIn?.error = getString(R.string.digite_o_login)
//            } else if (passwordSignIn?.text.isNullOrBlank()){
//                passwordSignIn?.error = getString(R.string.digite_a_senha)
//            } else if (repeatPasswordSignIn?.text.isNullOrBlank()){
//                repeatPasswordSignIn?.error = getString(R.string.digite_a_senha)
//            } else if (repeatPasswordSignIn!!.text.toString() != passwordSignIn!!.text.toString()) {
//                repeatPasswordSignIn!!.error = getString(R.string.senha_diferente)
//            }
//            else {
//                Snackbar.make(it,getString(R.string.sign_in),Snackbar.LENGTH_LONG).show()
//
//                findViewById<TextInputLayout>(R.id.et_username_login)
//                    .editText
//                    ?.text = nameSignIn?.text
//                findViewById<TextInputLayout>(R.id.et_senha_login)
//                    .editText
//                    ?.text = repeatPasswordSignIn.text
//
//                nameSignIn?.text?.clear()
//                passwordSignIn.text?.clear()
//                repeatPasswordSignIn.text?.clear()
//
//                Handler(Looper.getMainLooper()).postDelayed({
//                    pager_mainActivity.setCurrentItem(0,true)
//                }, 1000)

            }

    override fun mudarTab(position:Int) {
        val tabPosition = if (position == LOGIN_FRAGMENT) {
            SIGNUP_FRAGMENT
        } else LOGIN_FRAGMENT

        val tabNova = tab.getTabAt(tabPosition)
        tabNova?.select()
    }
}
