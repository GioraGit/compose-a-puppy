package com.example.androiddevchallenge.features.gallery.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

object GalleryScreen {
    const val route = "gallery"
}

@Composable
fun GalleryScreen(navController: NavController) {
    val viewModel = viewModel<GalleryViewModel>()
    val puppyGroups by viewModel.puppGroups.collectAsState(initial = emptyMap())

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                Text(text = "Home")
            }
            items(puppyGroups.entries.toList()) { group ->
                PuppyCardList(
                    title = group.key,
                    puppies = group.value,
                    contentHorizontalPadding = 16.dp
                )
            }
        }
    }
}