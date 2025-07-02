package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetBinHistoryUseCase
import com.example.presentation.states.BinHistoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BinHistoryViewModel @Inject constructor(
    private val getBinHistoryUseCase: GetBinHistoryUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<BinHistoryUiState>(BinHistoryUiState.Initial)
    val uiState: StateFlow<BinHistoryUiState> = _uiState

    fun fetchHistory() {
        try {
            _uiState.value = BinHistoryUiState.Loading
            val history = getBinHistoryUseCase()
            _uiState.value = BinHistoryUiState.Success(history)
        } catch (e: Exception) {
            _uiState.value = BinHistoryUiState.Error(e.message)
        }
    }
}