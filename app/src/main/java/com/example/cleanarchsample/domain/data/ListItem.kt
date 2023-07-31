package com.example.cleanarchsample.domain.data

data class ListItem(
    val id: Int,
    var isVisible: Boolean = false,
    var timeOnScreen: Long = 0
)
