package com.dossantosp.lab24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.pager_mainActivity)
        val tab = findViewById<TabLayout>(R.id.tabLayout_mainActivity)

        tab.setupWithViewPager(pager)

        val fragments = listOf(
            MeuFragment.newInstance("Paulo"),
            MeuFragment.newInstance("Jose"),
            MeuFragment.newInstance("Maria"),

        )

        val titulos = listOf(
            getString(R.string.home), getString(R.string.biblioteca), getString(R.string.favoritos)
        )

        pager.adapter = ViewPageAdapter(fragments,titulos,supportFragmentManager)

        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_menu_book_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_star_24)



        tab.getTabAt(1)!!.orCreateBadge.apply{
            number = 4
            maxCharacterCount = 3
            isVisible = true
        }

        tab.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.position == 1) {
                    tab.badge?.isVisible = false
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}