package com.example.tlu_hub

import android.Manifest
import android.app.Application
import com.example.tlu_hub.data_local.Preferences
import pub.devrel.easypermissions.EasyPermissions

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
//        val realmConfiguration = RealmConfiguration.Builder(this).build()
//        Realm.setDefaultConfiguration(realmConfiguration)
        // khoi tao cho Preferences
        Preferences.init(this)


    }


}
