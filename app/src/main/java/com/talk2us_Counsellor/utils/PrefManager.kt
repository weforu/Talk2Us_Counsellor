package com.talk2us_Counsellor.utils

import android.content.Context
import android.preference.PreferenceManager
import com.talk2us_Counsellor.MainApplication


object PrefManager {
    private val preference by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
    private val context: Context
        get() = MainApplication.instance.applicationContext

    fun putBoolean(preferenceKey: String, preferenceValue: Boolean) {
        preference.edit().putBoolean(preferenceKey, preferenceValue).apply()
    }

    fun getBoolean(preferenceKey: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(preferenceKey, defaultValue)
    }

    fun putString(str: String, preferenceValue: String) {
        preference.edit().putString(str, preferenceValue).apply()
    }

    fun getString(str: String, defaultValue: String): String? {
        return preference.getString(str, defaultValue)
    }

    fun getClientMessageToken(): String {
        return getString(Constants.CLIENT_MESSAGE_TOKEN, Constants.NOT_DEFINED) as String
    }

    fun getCounsellorId(): String {
        return PrefManager.getString(
            Constants.COUNSELLOR_ID,
            Constants.NOT_DEFINED
        ) as String
    }
    fun putClientMessageToken(str: String) {
        putString(Constants.CLIENT_MESSAGE_TOKEN, str)
    }

    fun getCounsellorMessageToken(): String {
        return getString(Constants.COUNSELLOR_MESSAGE_TOKEN, Constants.NOT_DEFINED) as String
    }

    fun putCounsellorMessageToken(str: String) {
        putString(Constants.COUNSELLOR_MESSAGE_TOKEN, str)
    }
}