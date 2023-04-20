package com.yachikajoshi.nasaappincompose.domain.repository

import com.yachikajoshi.nasaappincompose.domain.model.Picture

interface PictureRepository {
    fun getPictures(): List<Picture>
}