package com.example.tlu_hub

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tlu_hub.ui.home.HomeFragment
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity() {
    var navigationPosition: Int = 0

    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        initView()
        getFragment(HomeFragment.newInstance())

    }




    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar_main,
            R.string.app_name,
            R.string.app_name
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setUpBottomNavigation(){
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

        fluidBottomNavigation.onTabSelectedListener onTabSelected()

    }


    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }

    }

    private fun initView(){
        setSupportActionBar(toolbar_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setUpDrawerLayout()
        setUpBottomNavigation()


        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_home -> {
                    Toast.makeText(this, "The Mistbelt Forests", Toast.LENGTH_SHORT).show();
                }

            }
            menuItem.isChecked = true
            drawer_layout.closeDrawers()
            true
        }
    }


    //    @Override
    //    public boolean onCreateOptionsMenu(Menu menu) {
    //        getMenuInflater().inflate(R.menu.toobar_layout,menu);
    //        return true;
    //    }
    private fun getFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun navigateToFragment(fragmentToNavigate: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, fragmentToNavigate)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    //    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        toggle.onConfigurationChanged(newConfig)
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if (toggle.onOptionsItemSelected(item)) {
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }



}
