package com.yachikajoshi.nasaappincompose.ui.presentation

import android.util.Log
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.size.Scale
import com.yachikajoshi.nasaappincompose.domain.model.Picture

@Composable
fun PictureList(mainUiState: MainUiState, onPictureClicked: (index: Int) -> Unit) {

    LazyVerticalGrid(columns = GridCells.Adaptive(180.dp)) {
        itemsIndexed(mainUiState.pictures) { index, picture ->
            PictureItem(picture = picture, modifier = Modifier.clickable {
                onPictureClicked(index)
            })
        }
    }
}

@Composable
fun PictureItem(picture: Picture, modifier: Modifier = Modifier) {
    AsyncImage(
        model = picture.imageUrl,
        contentDescription = null,
        modifier = modifier
            .height(180.dp)
            .padding(2.dp)
            .clip(RoundedCornerShape(5)),
        contentScale = ContentScale.Crop
    )
}