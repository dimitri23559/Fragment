package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.fragment.HomeFragment
import com.example.myapplication.fragment.NotificationFragment
import com.example.myapplication.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homefragement = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homefragement)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.botton_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener{
           when(it.itemId){
               R.id.menu_home -> makeCurrentFragment(homefragement)
               R.id.menu_notification -> makeCurrentFragment(notificationFragment)
               R.id.menu_settings -> makeCurrentFragment(settingsFragment)
           }
            true
        }


    }

    private fun  makeCurrentFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav,fragment)
            commit()
        }
    }
}