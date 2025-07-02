package com.example.data.dto

import com.example.domain.models.BinInfo

data class BinInfoDto(
    val number: List<String?>,
    val scheme: String,
    val type: String,
    val brand: String,
    val country: Country,
    val bank: Bank
)

data class Country(
    val numeric: String,
    val alpha2: String,
    val name: String,
    val emoji: String,
    val currency: String,
    val latitude: Int,
    val longitude: Int,
)

data class Bank(
    val name: String
)


fun BinInfoDto.toBinInfo(): BinInfo {
    return BinInfo(
        number = number,
        scheme = scheme,
        type = type,
        brand = brand,
        country = com.example.domain.models.Country(
            numeric = country.numeric,
            alpha2 = country.alpha2,
            name = country.name,
            emoji = country.emoji,
            currency = country.currency,
            latitude = country.latitude,
            longitude = country.longitude
        ),
        bank = com.example.domain.models.Bank(
            name = bank.name
        )
    )
}