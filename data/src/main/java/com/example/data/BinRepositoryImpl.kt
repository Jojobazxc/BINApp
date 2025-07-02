package com.example.data

import com.example.data.dao.BinHistoryDao
import com.example.data.dto.toBinInfo
import com.example.data.network.BinApi
import com.example.domain.interfaces.BinRepository
import com.example.domain.models.BinInfo
import javax.inject.Inject

class BinRepositoryImpl @Inject constructor(
    private val binApi: BinApi,
    private val binHistoryDao: BinHistoryDao
): BinRepository {
    override suspend fun getBinInfo(bin: String): BinInfo {
        val binInfoDto = binApi.getBinInfo(bin)
        val binInfo = binInfoDto.toBinInfo()

        binHistoryDao.addToHistory(binInfo)

        return binInfo

    }

    override fun getHistory(): List<BinInfo> {
        return binHistoryDao.getHistory()
    }

}