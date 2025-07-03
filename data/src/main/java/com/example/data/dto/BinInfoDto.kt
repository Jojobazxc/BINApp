package com.example.data.dto

import com.example.domain.models.BinInfo

data class BinInfoDto(
    val number: NumberInfo,
    val scheme: String,
    val type: String,
    val brand: String,
    val country: Country,
    val bank: Bank
)

data class NumberInfo(
    val length: Int?,
    val luhn: Boolean?
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


fun BinInfoDto.toBinInfo(bin: String): BinInfo {
    return BinInfo(
        bin = bin,
        number = com.example.domain.models.NumberInfo(
            length = number.length,
            luhn = number.luhn
        ),
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