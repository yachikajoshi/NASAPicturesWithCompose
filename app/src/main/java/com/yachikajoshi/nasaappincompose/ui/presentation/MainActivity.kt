package com.yachikajoshi.nasaappincompose.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.yachikajoshi.nasaappincompose.ui.theme.NasaAppInComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaAppInComposeTheme {
                val viewModel = hiltViewModel<MainViewModel>()

                val navController = rememberAnimatedNavController()
                AnimatedNavHost(navController = navController, startDestination = "pictureList") {
                    composable("pictureList") {
                        PictureList(
                            mainUiState = viewModel.uiState.value,
                            onPictureClicked = { index ->
                                viewModel.updateSelectedIndex(index)
                                navController.navigate("pictureDetail")
                            })
                    }
                    composable("pictureDetail") {
                        PictureDetail(mainUiState = viewModel.uiState.value, onBackPressed = {
                            navController.navigateUp()
                        })
                    }
                }
            }
        }
    }
}