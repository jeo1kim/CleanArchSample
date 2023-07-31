package com.example.cleanarchsample.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.example.cleanarchsample.domain.data.ListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    // Simulate data source or get data from the repository
    private val dataList = mutableListOf<ListItem>().apply {
        for (i in 1..50) {
            add(ListItem(i))
        }
    }

    private val _listItems = MutableStateFlow(dataList.toList()) // Convert to immutable List
    val listItems: StateFlow<List<ListItem>> get() = _listItems

    // Method to update visibility of the items
    fun updateVisibility(itemId: Int, isVisible: Boolean) {
        _listItems.value = _listItems.value.map { item ->
            if (item.id == itemId) {
                item.copy(isVisible = isVisible) // Create a new ListItem with updated visibility
            } else {
                item
            }
        }
    }

    // Method to update time on screen of the items
    fun updateTimeOnScreen(itemId: Int, timeOnScreen: Long) {
        _listItems.value = _listItems.value.map { item ->
            if (item.id == itemId) {
                item.copy(timeOnScreen = timeOnScreen) // Create a new ListItem with updated timeOnScreen
            } else {
                item
            }
        }
    }
}