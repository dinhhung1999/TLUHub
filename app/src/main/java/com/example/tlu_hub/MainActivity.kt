package com.example.tlu_hub

import android.Manifest
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.tlu_hub.contraints.Constraint
import com.example.tlu_hub.contraints.Constraint.Companion.codeUser
import com.example.tlu_hub.contraints.Constraint.Companion.userData
import com.example.tlu_hub.contraints.Contraints
import com.example.tlu_hub.ui.discover.DiscoverFragment
import com.example.tlu_hub.ui.home.HomeFragment
import com.example.tlu_hub.ui.navigationDrawer.qrCode.QRCodeActivity
import com.example.tlu_hub.ui.navigationDrawer.qrCode.QrCodeFragment
import com.example.tlu_hub.ui.navigationDrawer.qrCode.QrCodePresenter
import com.example.tlu_hub.ui.post.IOnBackPressed
import com.example.tlu_hub.ui.post.PostFragment
import com.example.tlu_hub.ui.user.UserFragment
import com.king.zxing.Intents
import com.tenclouds.fluidbottomnavigation.FluidBottomNavigationItem
import com.tenclouds.fluidbottomnavigation.listener.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


class MainActivity: AppCompatActivity(),MainView {
    private val presenter = MainPresenter(this )
//    private val codeUser = Intent.get
    companion object {
        var navigationPosition: Int = 0
        private val MAINACTIVITY = 0
        val KEY_IS_QR_CODE = "key_code"
        val  KEY_IS_CONTINUOUS : String = "key_continuous_scan"
        val REQUEST_CODE_SCAN = 0X01
        val REQUEST_CODE_PHOTO = 0X02

        const val RC_CAMERA = 0X01

        val RC_READ_PHOTO = 0X02

    }
    private val cls: Class<*>? = null
    private val title: String? = null
    private val isContinuousScan = false


    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.getUserData(codeUser)
        initView()
        getFragment(DiscoverFragment.newInstance())

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


        fluidBottomNavigation.onTabSelectedListener = object : OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                when (fluidBottomNavigation.items[position]) {
                    fluidBottomNavigation.items[0] -> {
                        nav_view.setCheckedItem(R.id.nav_item_home)
                        getFragment(HomeFragment.newInstance())

                    }
                    fluidBottomNavigation.items[1] -> {
                        getFragment(DiscoverFragment.newInstance())
                    }
                    fluidBottomNavigation.items[2] -> {
                        nav_view.setCheckedItem(R.id.nav_item_info)
                        getFragment(UserFragment.newInstance())
                    }
                }
            }
        }
    }
    fun getFragment(fragment: Fragment) {
        try {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        if (navigationPosition == R.layout.fragment_post) {
            navigationPosition = R.layout.fragment_discover
            getFragment(DiscoverFragment.newInstance())
        } else {
            super.onBackPressed()
        }
    }

    private fun initView(){
        setSupportActionBar(toolbar_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        setUpDrawerLayout()
        setUpBottomNavigation()

        nav_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_home -> {
                    fluidBottomNavigation.selectTab(0)
                    getFragment(HomeFragment.newInstance())
                }
                R.id.nav_item_info -> {
                    fluidBottomNavigation.selectTab(2)
                    getFragment(UserFragment.newInstance())
                }
                R.id.nav_item_qrCode -> {
                    GlobalScope.launch { // launch a new coroutine in background and continue
                        delay(210L) //
                        checkCameraPermissions()
                    }
//                    startActivity(Intent(this, QRCodeActivity::class.java))
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



private  fun startScan(cls: Class<*>, title: String) {
    val optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.`in`, R.anim.out)
    val intent = Intent(this, cls)
    intent.putExtra(MainActivity.KEY_IS_CONTINUOUS, isContinuousScan)
    ActivityCompat.startActivityForResult(
            this,
            intent,
            REQUEST_CODE_SCAN,
            optionsCompat.toBundle()
    )
}

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)

    }

    @AfterPermissionGranted(RC_CAMERA)
    private  fun checkCameraPermissions() {
    val perms = arrayOf(Manifest.permission.CAMERA)
    if (EasyPermissions.hasPermissions(this, *perms)) { //有权限
        startScan(QRCodeActivity::class.java, "scan")
    } else {
        EasyPermissions.requestPermissions(
                this, "Ứng dụng cần được cấp quyền Camera để tiếp tục sử dụng tính năng này",
                RC_CAMERA, *perms
        )
    }
}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && data != null) {
            when (requestCode) {
                REQUEST_CODE_SCAN -> {
                    val result = data.getStringExtra(Intents.Scan.RESULT)
                    getFragment(QrCodeFragment.newInstance(result.toString()))
                }
            }
        }
    }

    override fun onSetProfile() {
        Glide
                .with(this)
                .load(Contraints.BASE_URL + Constraint.userData[0].avatar_student.formats.medium.url)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .error(R.drawable.ic_round_error_outline_24)
                ?.into(nav_header_imageView)
        tvNameUserInHeader.text = userData[0].name_student

    }

}
