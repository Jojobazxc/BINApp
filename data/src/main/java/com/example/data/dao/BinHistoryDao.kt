package com.example.data.dao

import android.content.SharedPreferences
import com.example.domain.models.BinInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class BinHistoryDao @Inject constructor(
    private val prefs: SharedPreferences
) {
    private val gson = Gson()
    private val key = "bin_history"

    private fun saveHistory(history: List<BinInfo>) {
        val json = gson.toJson(history)
        prefs.edit().putString(key, json).apply()
    }

    fun getHistory(): List<BinInfo> {
        val json = prefs.getString(key, null) ?: return emptyList()
        val type = object : TypeToken<List<BinInfo>>() {}.type
        return gson.fromJson(json, type)
    }

    fun addToHistory(binInfo: BinInfo) {
        val history = getHistory().toMutableList()
        if (!history.contains(binInfo)) {
            history.add(0, binInfo)
            saveHistory(history)
        }
    }

    fun clearHistory() {
        prefs.edit().remove(key).apply()
    }

}