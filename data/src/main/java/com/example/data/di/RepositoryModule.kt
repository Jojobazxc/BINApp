package com.example.data.di

import com.example.data.BinRepositoryImpl
import com.example.domain.interfaces.BinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindBinRepository(
        impl: BinRepositoryImpl
    ): BinRepository
}