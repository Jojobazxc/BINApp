package com.example.domain.interfaces

import com.example.domain.models.BinInfo

interface BinRepository {
    suspend fun getBinInfo(bin: String): BinInfo
    fun getHistory(): List<BinInfo>
}