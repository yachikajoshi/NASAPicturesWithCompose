package com.yachikajoshi.nasaappincompose.data.repository

import android.app.Application
import com.yachikajoshi.nasaappincompose.app.util.parseListFromAssets
import com.yachikajoshi.nasaappincompose.data.dto.PictureDto
import com.yachikajoshi.nasaappincompose.data.mapper.toPicture
import com.yachikajoshi.nasaappincompose.domain.model.Picture
import com.yachikajoshi.nasaappincompose.domain.repository.PictureRepository
import javax.inject.Inject

class PictureRepositoryImpl @Inject constructor(private val application: Application) :
    PictureRepository {

    override fun getPictures(): List<Picture> {
        val spaceFactDtoList = parseListFromAssets<PictureDto>(
            context = application,
            filename = JSON_FILE_NAME
        )
        return spaceFactDtoList.map { it.toPicture() }
    }

    companion object {
        const val JSON_FILE_NAME = "data.json"
    }
}