package com.seogaemo.hackseoul_android.database

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {
    private const val NAME = "SharedPreference"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_FIRST = Pair("isFirst", true)
    private val TOKEN = Pair("token", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isFirst: Boolean
        get() = preferences.getBoolean(IS_FIRST.first, IS_FIRST.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST.first, value)
        }
    var token: String
        get() = preferences.getString(TOKEN.first, TOKEN.second) ?: ""
        set(value) = preferences.edit {
            it.putString(TOKEN.first, value)
        }
}