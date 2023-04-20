package com.yachikajoshi.nasaappincompose.data.mapper

import com.yachikajoshi.nasaappincompose.app.util.formatDate
import com.yachikajoshi.nasaappincompose.data.dto.PictureDto
import com.yachikajoshi.nasaappincompose.domain.model.Picture

fun PictureDto.toPicture(): Picture {
    return Picture(
        title = this.title ?: "",
        date = formatDate(this.date) ?: "",
        explanation = this.explanation ?: "",
        imageUrl = this.url ?: "",
        hdImageUrl = this.hdUrl ?: ""
    )
}