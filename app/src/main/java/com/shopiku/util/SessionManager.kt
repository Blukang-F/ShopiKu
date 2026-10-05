package com.shopiku.util

import android.content.Context
import android.content.SharedPreferences

object SessionManager {
    private const val PREF_NAME = "shopiku_session"
    private const val KEY_TOKEN = "token"
    private const val KEY_USER_NAME = "user_name"
    private const val KEY_USER_EMAIL = "user_email"

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(context: Context, token: String) {
        prefs(context).edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(context: Context): String? =
        prefs(context).getString(KEY_TOKEN, null)

    fun isLoggedIn(context: Context): Boolean =
        !getToken(context).isNullOrEmpty()

    fun saveUser(context: Context, name: String, email: String) {
        prefs(context).edit()
            .putString(KEY_USER_NAME, name)
            .putString(KEY_USER_EMAIL, email)
            .apply()
    }

    fun getUserName(context: Context): String =
        prefs(context).getString(KEY_USER_NAME, "Budi Santoso") ?: "Budi Santoso"

    fun getUserEmail(context: Context): String =
        prefs(context).getString(KEY_USER_EMAIL, "budi@example.com") ?: "budi@example.com"

    fun clearSession(context: Context) {
        prefs(context).edit().clear().apply()
    }
}
