package com.yachikajoshi.nasaappincompose.ui.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yachikajoshi.nasaappincompose.R
import com.yachikajoshi.nasaappincompose.domain.model.Picture

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureDetail(mainUiState: MainUiState, onBackPressed: () -> Unit) {
    val pagerState = rememberPagerState()

    LaunchedEffect(key1 = mainUiState.selectedIndex) {
        pagerState.scrollToPage(mainUiState.selectedIndex)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(title = {}, navigationIcon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.baseline_arrow_back_24
                ),
                contentDescription = null, modifier = Modifier.clickable { onBackPressed() }
            )
        })
        HorizontalPager(
            pageCount = mainUiState.pictures.size, state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { currentPage ->
            PictureDetailItem(picture = mainUiState.pictures[currentPage])
        }
    }

}

@Composable
fun PictureDetailItem(picture: Picture) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
    ) {
        AsyncImage(
            model = picture.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(5)),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${picture.title} (${picture.date})",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text(
            text = picture.explanation,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}