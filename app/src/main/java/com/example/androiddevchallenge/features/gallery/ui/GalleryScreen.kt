package com.example.androiddevchallenge.features.gallery.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Gender
import com.example.androiddevchallenge.domain.Puppy

object GalleryScreen {
    val route = "gallery"
}

private val puppies by lazy {
    listOf(
        Puppy("Ralph", Gender.Male, Breed.Bulldog),
        Puppy("Milkee", Gender.Female, Breed.Poodle),
        Puppy("Sam", Gender.Male, Breed.Foxhound),
        Puppy("Rosie", Gender.Female, Breed.Pomeranian),
        Puppy("Pumbaa", Gender.Female, Breed.GermanShephered),
        Puppy("Frank", Gender.Male, Breed.Pug),
        Puppy("Schatz", Gender.Male, Breed.GiantSchnaouzer),
        Puppy("Maya", Gender.Female, Breed.GolderRetriever),
        Puppy("Lucky", Gender.Female, Breed.Pekingese),
        Puppy("Kite", Gender.Female, Breed.AiredaleTerrier),
        Puppy("Zorro", Gender.Male, Breed.Komondor),
        Puppy("Jacob", Gender.Male, Breed.IrishSetter),
        Puppy("Mario", Gender.Male, Breed.GreatDane),
        Puppy("Missy", Gender.Female, Breed.CockerSpaniel),
        Puppy("Snickers", Gender.Female, Breed.Akita),
        Puppy("Johnny", Gender.Female, Breed.Harrier),
        Puppy("Skipps", Gender.Female, Breed.Rottweiler),
        Puppy("Atlas", Gender.Female, Breed.Labrador),
        Puppy("Gary", Gender.Female, Breed.Greyhound),
    )
}

private val puppyGroups by lazy {
    mapOf(
        "Recently Added" to listOf(
            Puppy("Ralph", Gender.Male, Breed.Bulldog),
            Puppy("Milkee", Gender.Female, Breed.Poodle),
            Puppy("Sam", Gender.Male, Breed.Foxhound),
            Puppy("Rosie", Gender.Female, Breed.Pomeranian)
        ),
        "Most Viewed" to listOf(
            Puppy("Pumbaa", Gender.Female, Breed.GermanShephered),
            Puppy("Frank", Gender.Male, Breed.Pug),
            Puppy("Schatz", Gender.Male, Breed.GiantSchnaouzer),
            Puppy("Sam", Gender.Male, Breed.Foxhound)
        ),
        "Trending" to listOf(
            Puppy("Rosie", Gender.Female, Breed.Pomeranian),
            Puppy("Frank", Gender.Male, Breed.Pug),
            Puppy("Milkee", Gender.Female, Breed.Poodle),
            Puppy("Lucky", Gender.Female, Breed.Pekingese)
        ),
        "All Time Classic Breeds" to listOf(
            Puppy("Maya", Gender.Female, Breed.GolderRetriever),
            Puppy("Atlas", Gender.Female, Breed.Labrador),
            Puppy("Missy", Gender.Female, Breed.CockerSpaniel),
            Puppy("Pumbaa", Gender.Female, Breed.GermanShephered),
            Puppy("Ralph", Gender.Male, Breed.Bulldog)
        ),
        "All" to puppies
    )
}

@Composable
fun GalleryScreen(navController: NavController) {
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