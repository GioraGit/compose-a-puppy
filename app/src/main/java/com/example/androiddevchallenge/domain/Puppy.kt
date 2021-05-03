package com.example.androiddevchallenge.domain

import java.util.Date

data class Puppy(
    val name: String,
    val gender: Gender,
    val breed: Breed,
    val description: String = "",
    val added: Date = Date()
)