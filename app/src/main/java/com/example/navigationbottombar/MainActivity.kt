package com.example.navigationbottombar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*
        val bottomNavigation=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController(R.id.fragmentContainerView)

       *//* val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)*//*
        bottomNavigation.setupWithNavController(navController)*/

        val bottomNavigation=findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        val thirdFragment=ThirdFragment()

        setCurrentFragment(firstFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home->setCurrentFragment(firstFragment)
                R.id.ic_settings->setCurrentFragment(secondFragment)
                R.id.ic_profile->setCurrentFragment(thirdFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView,fragment)
            commit()
        }

}