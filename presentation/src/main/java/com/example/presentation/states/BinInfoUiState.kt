package com.example.presentation.states

import com.example.domain.models.BinInfo

sealed class BinInfoUiState {
    data object Initial : BinInfoUiState()
    data object Loading: BinInfoUiState()
    data class Success(val binInfo: BinInfo): BinInfoUiState()
    data class Error(val eMessage: String?): BinInfoUiState()
}