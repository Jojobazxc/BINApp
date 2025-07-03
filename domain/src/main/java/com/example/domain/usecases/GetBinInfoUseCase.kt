package com.example.domain.usecases

import com.example.domain.interfaces.BinRepository
import com.example.domain.models.BinInfo
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(
    private val repository: BinRepository
) {
    suspend operator fun invoke(bin: String): BinInfo {
        return repository.getBinInfo(bin)
    }
}