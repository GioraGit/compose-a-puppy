package com.example.androiddevchallenge.features.gallery.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.composables.ACard
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyCard(
    name: String,
    gender: String,
    breed: String
) {
    ACard(
        modifier = Modifier
            .requiredWidth(150.dp)
            .requiredHeight(210.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .background(color = Color(0xFFBB86FC))
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = name,
                        fontSize = 15.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row {
                    Column {
                        Text(
                            text = gender,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = breed,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview(name = "Light Theme", widthDp = 170, heightDp = 230, backgroundColor = 0xF2F2F7, showBackground = true)
@Composable
fun PupyCardLightPreview() {
    MyTheme(darkTheme = false) {
        PuppyCard(
            name = "George the first from castle",
            gender = "Male",
            breed = "Bull Terrier"
        )
    }
}

@Preview(name = "Dark Theme", widthDp = 170, heightDp = 230, backgroundColor = 0x121212, showBackground = true)
@Composable
fun PupyCardDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyCard(
            name = "George the first from castle",
            gender = "Male",
            breed = "Bull Terrier"
        )
    }
}