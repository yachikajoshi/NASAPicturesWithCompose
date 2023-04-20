package com.yachikajoshi.nasaappincompose.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yachikajoshi.nasaappincompose.ui.theme.NasaAppInComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaAppInComposeTheme {
                val viewModel = hiltViewModel<MainViewModel>()

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pictureList") {
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