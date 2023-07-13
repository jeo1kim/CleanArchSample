package com.example.cleanarchsample.presentation

sealed class Screen(val route: String) {
    object ScreenName: Screen("coin_list_screen")
}
