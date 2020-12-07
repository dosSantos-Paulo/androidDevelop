package com.example.fakewhatsapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.fakewhatsapp.home.contacts.ContactFragment
import com.example.fakewhatsapp.R
import com.example.fakewhatsapp.home.call.CallFragment
import com.example.fakewhatsapp.home.status.StatusFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager_mainActivity)
        val tabLalayout = findViewById<TabLayout>(R.id.tabLayout_mainActivity)
        val fragments = listOf(CallFragment(), StatusFragment(), ContactFragment())
        val title = listOf(getString(R.string.calls), getString(R.string.status), getString(R.string.contacts))

        tabLalayout.setupWithViewPager(viewPager)

        viewPager.adapter = ViewPagerAdapter(fragments, title, supportFragmentManager)
    }
}