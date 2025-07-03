package com.example.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HistoryScreen() {

    AsyncImage(
        model = "https://flagcdn.com/w40/ru.png",
        contentDescription = "",
        modifier = Modifier
            .size(40.dp)
        ,
        onSuccess = {
            Log.d("Image", "Success")
        },
        onError = {
            Log.d("Image", "Error")
        },
        onLoading = {
            Log.d("Image", "Loading")
        }
    )

    Text("acccccccc", fontSize = 20.sp)
}