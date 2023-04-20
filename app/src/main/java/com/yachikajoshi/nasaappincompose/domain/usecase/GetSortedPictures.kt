package com.yachikajoshi.nasaappincompose.domain.usecase

import com.yachikajoshi.nasaappincompose.domain.model.Picture
import com.yachikajoshi.nasaappincompose.domain.repository.PictureRepository

class GetSortedPictures(private val pictureRepository: PictureRepository) {
    operator fun invoke(): List<Picture> {
        val spaceFacts = pictureRepository.getPictures()
        return spaceFacts.sortedByDescending { it.date }
    }
}