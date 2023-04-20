package com.yachikajoshi.nasaappincompose.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import com.yachikajoshi.nasaappincompose.domain.repository.PictureRepository
import com.yachikajoshi.nasaappincompose.domain.usecase.GetSortedPictures

@Module
@InstallIn(ViewModelComponent::class)
class UsecaseModule {

    @Provides
    fun provideGetSortedFactsUseCase(pictureRepository: PictureRepository) =
        GetSortedPictures(pictureRepository)

}