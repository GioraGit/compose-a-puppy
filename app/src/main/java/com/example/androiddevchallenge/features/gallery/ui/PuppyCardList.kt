package com.example.androiddevchallenge.features.gallery.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Gender
import com.example.androiddevchallenge.domain.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyCardList(
    title: String,
    puppies: List<Puppy>,
    contentHorizontalPadding: Dp = 0.dp
) {
    Column {
        Text(
            modifier = Modifier.padding(start = contentHorizontalPadding),
            text = title,
            color = MaterialTheme.colors.onSurface,
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = contentHorizontalPadding, vertical = 16.dp),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(puppies) {
                PuppyCard(
                    name = it.name,
                    gender = stringResource(it.gender.displayResource),
                    breed = it.breed.name
                )
            }
        }
    }
}

@Preview(name = "Light Theme", backgroundColor = 0xF2F2F7, showBackground = true)
@Composable
fun PuppyCardListLightPreview() {
    MyTheme(darkTheme = false) {
        PuppyCardList(
            title = "Recently Added",
            puppies = generatePuppies(20),
            contentHorizontalPadding = 16.dp
        )
    }
}

@Preview(name = "Dark Theme", backgroundColor = 0x121212, showBackground = true)
@Composable
fun PuppyCardListDarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyCardList(
            title = "Recently Added",
            puppies = generatePuppies(20)
        )
    }
}

private fun generatePuppies(count: Int): List<Puppy> {
    val puppies = mutableListOf<Puppy>()
    repeat(count) {
        puppies.add(Puppy("Ralph", Gender.Male, Breed.Bulldog))
    }
    return puppies
}