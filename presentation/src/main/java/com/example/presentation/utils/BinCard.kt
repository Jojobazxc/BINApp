package com.example.presentation.utils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.util.Locale

@Composable
fun BinInfoCard(
    length: String,
    luhn: String,
    scheme: String,
    type: String,
    brand: String,
    countryName: String,
    countryCode: String,
    latitude: Int,
    longitude: Int,
    bank: String
) {
    val flagUrl = "https://flagcdn.com/w80/${countryCode.lowercase()}.png"
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
        ) {
            Text("CARD NUMBER", style = MaterialTheme.typography.titleSmall)

            Text(
                "Length: ${(if (length == "null") "?" else length)}",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                "Luhn: ${(if (luhn == "null") "?" else luhn)}",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            HorizontalDivider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("SCHEME", style = MaterialTheme.typography.labelSmall)
                Text(scheme.uppercase(), style = MaterialTheme.typography.titleMedium)
            }

            HorizontalDivider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("TYPE", style = MaterialTheme.typography.labelSmall)
                    Text(type, style = MaterialTheme.typography.titleMedium)
                }
                Column {
                    Text("BRAND", style = MaterialTheme.typography.labelSmall)
                    Text(brand, style = MaterialTheme.typography.titleMedium)
                }
            }

            HorizontalDivider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = "https://flagcdn.com/w40/${countryCode.lowercase(Locale.ROOT)}.png",
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
                Spacer(Modifier.width(8.dp))
                Column {
                    Text("$countryCode $countryName", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "latitude: $latitude, longitude: $longitude",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

            HorizontalDivider()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("BANK", style = MaterialTheme.typography.labelSmall)
                Text(bank, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BinInfoCard(
        length = "?",
        luhn = "No",
        scheme = "Visa",
        type = "Credit",
        brand = "Gold",
        countryName = "Denmark",
        // 🇩🇰
        countryCode = "DK",
        latitude = 56,
        longitude = 10,
        bank = "Sberbank"
    )

}