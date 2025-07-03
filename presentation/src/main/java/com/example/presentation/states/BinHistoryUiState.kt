package com.example.presentation.states

import com.example.domain.models.BinInfo

sealed class BinHistoryUiState {
    data object Initial : BinHistoryUiState()
    data object Loading: BinHistoryUiState()
    data class Success(val history: List<BinInfo>): BinHistoryUiState()
    data class Error(val eMessage: String?): BinHistoryUiState()
}