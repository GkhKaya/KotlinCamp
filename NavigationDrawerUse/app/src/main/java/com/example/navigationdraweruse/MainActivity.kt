package com.example.navigationdraweruse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_tittle.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment  = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(navigationView,navHostFragment.navController)

        toolbar.title = "Title"

        val toggle = ActionBarDrawerToggle(this,drawer,toolbar,0,0)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val title = navigationView.inflateHeaderView(R.layout.navigation_tittle)
        title.textViewTitle.text = "Hello"
    }

    override fun onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }


    }
}