package com.example.cleanarchsample.presentation.main_screen

import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cleanarchsample.domain.data.ListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {

    val listItems by viewModel.listItems.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(listItems.size) { index ->
            val item = listItems[index]
            ListItemWithTimerAndBlinking(
                item = item,
                onVisibilityChanged = { isVisible ->
                    viewModel.updateVisibility(item.id, isVisible)
                },
                onTimeUpdated = { timeOnScreen ->
                    viewModel.updateTimeOnScreen(item.id, timeOnScreen)
                }
            )
        }
    }

}

@Composable
fun ListItemWithTimerAndBlinking(
    item: ListItem,
    onVisibilityChanged: (Boolean) -> Unit,
    onTimeUpdated: (Long) -> Unit
) {
    var isVisible by remember { mutableStateOf(true) }
    var startTime by remember { mutableStateOf(item.timeOnScreen) }

    // Trigger the effect when the visibility changes
    LaunchedEffect(isVisible) {
        if (isVisible) {
            // Start the coroutine to continuously update the time
            while (isActive) {
                startTime +=  1
                onTimeUpdated(startTime)
                // Small delay to avoid excessive updates
                delay(1000L)
            }
        } else {
        }
    }

    val flashAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(Color.Cyan.copy(flashAnimation)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Your content for the item goes here
        // For example, display the timer text
        // and animate a blinking light using the isBlinking flag

        Text(text = item.timeOnScreen.toString())
    }
}
