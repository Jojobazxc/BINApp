package com.example.domain.usecases

import com.example.domain.interfaces.BinRepository
import com.example.domain.models.BinInfo

class GetBinInfoUseCase(
    private val repository: BinRepository
) {
    suspend operator fun invoke(bin: String): BinInfo {
        return repository.getBinInfo(bin)
    }
}