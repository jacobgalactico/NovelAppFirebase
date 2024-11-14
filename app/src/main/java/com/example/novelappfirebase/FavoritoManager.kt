package com.example.novelappfirebase

import android.content.Context
import android.content.SharedPreferences

class FavoritesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("favorites_prefs", Context.MODE_PRIVATE)

    fun saveFavorite(item: String) {
        val editor = sharedPreferences.edit()
        editor.putString(item, item)
        editor.apply()
    }

    fun removeFavorite(item: String) {
        val editor = sharedPreferences.edit()
        editor.remove(item)
        editor.apply()
    }

    fun getFavorites(): Set<String> {
        return sharedPreferences.all.keys
    }
}