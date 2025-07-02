package com.example.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.ui.theme.ButtonsColor
import com.example.presentation.ui.theme.MainFontFamily
import com.example.presentation.viewmodels.BinInfoViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun BinInfoScreen() {
    val viewModel: BinInfoViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.33f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "BIN",
                fontSize = 24.sp,
                fontFamily = MainFontFamily,
                fontWeight = FontWeight.Bold,
                color = ButtonsColor
                )
        }
    }

}

@Preview
@Composable
private fun Preview() {
    BinInfoScreen()
}