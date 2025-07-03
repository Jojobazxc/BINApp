package com.example.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.states.BinInfoUiState
import com.example.presentation.ui.theme.ButtonsColor
import com.example.presentation.ui.theme.MainBGColor
import com.example.presentation.ui.theme.MainFontFamily
import com.example.presentation.utils.BinInfoCard
import com.example.presentation.viewmodels.BinInfoViewModel


@Composable
fun BinInfoScreen() {
    val viewModel: BinInfoViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    val binState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MainBGColor)
    ) {
        Box(
            modifier = Modifier
                .weight(if (state.value == BinInfoUiState.Initial) 0.33f else 0.25f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "BIN",
                fontSize = 36.sp,
                fontFamily = MainFontFamily,
                fontWeight = FontWeight.Bold,
                color = ButtonsColor
            )

        }
        Box(
            modifier = Modifier
                .weight(if (state.value == BinInfoUiState.Initial) 0.33f else 0.15f)
                .fillMaxWidth(),
            contentAlignment = if (state.value == BinInfoUiState.Initial) Alignment.Center else Alignment.TopCenter

        ) {
            TextField(
                value = binState.value,
                onValueChange = {
                    if (it.length <= 8) {
                        binState.value = it
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = ButtonsColor,
                    unfocusedTextColor = ButtonsColor,
                    unfocusedContainerColor = MainBGColor,
                    focusedContainerColor = MainBGColor,
                    focusedIndicatorColor = ButtonsColor,
                    unfocusedIndicatorColor = ButtonsColor
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),

            )
        }

        Box(
            modifier = Modifier
                .weight(if (state.value == BinInfoUiState.Initial) 0.33f else 0.15f)
                .fillMaxWidth(),
            contentAlignment = if (state.value == BinInfoUiState.Initial) Alignment.BottomCenter else Alignment.TopCenter

        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = {
                    viewModel.fetchBinInfo(binState.value)
                },
                content = {
                    Text(
                        text = "ИСКАТЬ",
                        fontFamily = MainFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                },
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = ButtonsColor,
                        contentColor = Color.White
                    )
            )
        }
        if (state.value != BinInfoUiState.Initial) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.45f)
                    .padding(16.dp),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    )
            ) {
                when (state.value) {
                    is BinInfoUiState.Loading -> {
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
                    is BinInfoUiState.Success -> {
                        with((state.value as BinInfoUiState.Success).binInfo) {
                            BinInfoCard(
                                length = number.length.toString(),
                                luhn = number.luhn.toString(),
                                scheme = scheme,
                                type = type,
                                brand = brand,
                                countryName = country.name,
                                countryCode = country.alpha2,
                                latitude = country.latitude,
                                longitude = country.longitude,
                                bank = bank.name
                            )
                        }

                    }

                    is BinInfoUiState.Error -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Произошла ошибка. Повторите попытку позже.",
                                fontFamily = MainFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    BinInfoUiState.Initial -> {

                    }
                }
            }
        }
    }

}

@Preview
@Composable
private fun Preview() {
    BinInfoScreen()
}