package com.example.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.GetBinInfoUseCase
import com.example.presentation.states.BinInfoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinInfoViewModel @Inject constructor(
    private val getBinInfoUseCase: GetBinInfoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BinInfoUiState>(BinInfoUiState.Initial)
    val uiState: StateFlow<BinInfoUiState> = _uiState

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            _uiState.value = BinInfoUiState.Loading
            try {
                val info = getBinInfoUseCase(bin)
                _uiState.value = BinInfoUiState.Success(info)
                Log.d("Info", _uiState.value.toString())
            } catch (e: Exception) {
                _uiState.value = BinInfoUiState.Error(e.message)
            }
        }
    }
}