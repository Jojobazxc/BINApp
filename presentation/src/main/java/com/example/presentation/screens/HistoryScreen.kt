package com.example.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.states.BinHistoryUiState
import com.example.presentation.ui.theme.ButtonsColor
import com.example.presentation.utils.BinInfoCard
import com.example.presentation.viewmodels.BinHistoryViewModel

@Composable
fun HistoryScreen() {

    val viewModel: BinHistoryViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()
    
    LaunchedEffect (Unit) { 
        viewModel.fetchHistory()
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) { 
        when (state.value) {
            is BinHistoryUiState.Error -> {
                
            }
            BinHistoryUiState.Initial -> {}
            BinHistoryUiState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = ButtonsColor
                        )
                    }
                }
            }
            is BinHistoryUiState.Success -> {
                items((state.value as BinHistoryUiState.Success).history) { 
                    BinInfoCard(
                        bin = it.bin,
                        length = it.number.length.toString(),
                        luhn = it.number.luhn.toString(),
                        scheme = it.scheme,
                        type = it.type,
                        brand = it.brand,
                        countryName = it.country.name,
                        countryCode = it.country.alpha2,
                        latitude = it.country.latitude,
                        longitude = it.country.longitude,
                        bank = it.bank.name
                    )
                }
            }
        }
    }

}