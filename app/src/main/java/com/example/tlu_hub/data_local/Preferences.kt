package com.example.tlu_hub.data_local

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.tlu_hub.R

class Preferences private constructor(val context: Context) {
    private val appName = context.getString(R.string.app_name)
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(appName, Context.MODE_PRIVATE)

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var instance: Preferences? = null

        fun getInstance(): Preferences {
            if (instance == null) {
                throw IllegalAccessException("Preferences must be initialized in Application class first.")
            }
            return instance as Preferences
        }

        fun init(context: Context) {
            instance = Preferences(context)
        }
    }

    fun saveToken(token: String) {
        sharedPreferences.edit().putString("token", token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun clearToken() {
        sharedPreferences.edit().remove("token").apply()
    }

    fun saveAccount(account: String, password: String) {
        sharedPreferences.edit().putString("account", account).putString("password", password)
            .apply()
    }

    fun clearAccount() {
        sharedPreferences.edit().remove("account").remove("password").apply()
    }

    fun getAccount(): String? {
        return sharedPreferences.getString("account", null)
    }

    fun getPassword(): String? {
        return sharedPreferences.getString("password", null)
    }

    fun saveRoleId(roleId: Int) {
        sharedPreferences.edit().putInt("roleId", roleId).apply()
    }

    fun getRoleId(): Int {
        return sharedPreferences.getInt("roleId", -1)
    }

    fun saveFullname(fullname: String) {
        sharedPreferences.edit().putString("fullname", fullname).apply()
    }

    fun getFullname(): String? {
        return sharedPreferences.getString("fullname", null)
    }

    fun saveUsername(fullname: String) {
        sharedPreferences.edit().putString("username", fullname).apply()
    }

    fun getUsername(): String? {
        return sharedPreferences.getString("username", null)
    }

    fun saveUserInfor(
        account: String,
        password: String,
        fullname: String,
        phone: String,
        avatar: String?,
        email: String?,
        company: String?,
        position: String?
    ) {
        sharedPreferences.edit().putString("account", account)
            .putString("password", password).putString("fullname", fullname)
            .putString("phone", phone).putString("avatar", avatar)
            .putString("email", email).putString("company", company)
            .putString("position", position).apply()
    }

    fun getPhone(): String? {
        return sharedPreferences.getString("phone", null)
    }

    fun getAvatar(): String? {
        return sharedPreferences.getString("avatar", null)
    }

    fun getEmail(): String? {
        return sharedPreferences.getString("email", null)
    }

    fun getCompany(): String? {
        return sharedPreferences.getString("company", null)
    }

    fun getPosition(): String? {
        return sharedPreferences.getString("position", null)
    }

    fun clearUserInfor() {
        sharedPreferences.edit().remove("account").remove("password").remove("fullname")
            .remove("phone")
            .remove("avatar").remove("email").remove("company").remove("position").apply()
    }

    fun saveAvatar(avatar: String) {
        sharedPreferences.edit().putString("avatar", avatar).apply()
    }
}