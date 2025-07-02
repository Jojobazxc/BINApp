package com.example.domain.usecases

import com.example.domain.interfaces.BinRepository
import com.example.domain.models.BinInfo
import javax.inject.Inject

class GetBinHistoryUseCase @Inject constructor(
    private val repository: BinRepository
) {
    operator fun invoke(): List<BinInfo> {
        return repository.getHistory()
    }
}