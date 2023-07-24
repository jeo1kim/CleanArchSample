package com.example.cleanarchsample.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanarchsample.data.remote.dto.StockDto
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockSearchScreen(
    viewModel: StockListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    var searchString by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {


        Column(modifier = Modifier.fillMaxSize()) {
            TextField(modifier = Modifier.fillMaxWidth(),
                value = searchString,
                onValueChange = {
                    searchString = it
                }
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                val localList = if (searchString.isEmpty()) state.data else state.data.filter {
                    it.instrument_type == searchString
                }

                items(localList) {
                    StockItem(it)
                }
            }
        }
    }
}

@Composable
fun StockItem(stock: StockDto) {

    Text(text = stock.name)
}
