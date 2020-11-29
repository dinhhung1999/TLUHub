package com.example.tlu_hub

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.tlu_hub.ui.login.LoginActivity
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.GravityCompat


class MainActivity : AppCompatActivity() {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name)
        drawer.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        fluidBottomNavigation.accentColor = ContextCompat.getColor(this, R.color.blue)
        fluidBottomNavigation.backColor = ContextCompat.getColor(this, R.color.blue)
        fluidBottomNavigation.textColor = ContextCompat.getColor(this, R.color.blue)
        fluidBottomNavigation.iconColor = ContextCompat.getColor(this, R.color.grey)
        fluidBottomNavigation.iconSelectedColor = ContextCompat.getColor(this, R.color.white)

        fluidBottomNavigation.items =
            listOf(
                FluidBottomNavigationItem(
                    getString(R.string.home),
                    ContextCompat.getDrawable(this, R.drawable.ic_round_home_24)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.discover),
                    ContextCompat.getDrawable(this, R.drawable.ic_round_library_books_24)
                ),
                FluidBottomNavigationItem(
                    getString(R.string.user),
                    ContextCompat.getDrawable(this, R.drawable.ic_round_person_24)
                )
            )
        fluidBottomNavigation.selectTab(1)

    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}