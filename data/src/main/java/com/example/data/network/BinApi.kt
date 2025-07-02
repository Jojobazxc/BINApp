package com.example.data.network

import com.example.data.dto.BinInfoDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface BinApi {
    @Headers("Accept-Version: 3")
    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoDto
}