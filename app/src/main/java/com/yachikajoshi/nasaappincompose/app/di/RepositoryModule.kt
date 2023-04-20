package com.yachikajoshi.nasaappincompose.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.yachikajoshi.nasaappincompose.domain.repository.PictureRepository
import com.yachikajoshi.nasaappincompose.data.repository.PictureRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPictureRepository(pictureRepositoryImpl: PictureRepositoryImpl): PictureRepository
}