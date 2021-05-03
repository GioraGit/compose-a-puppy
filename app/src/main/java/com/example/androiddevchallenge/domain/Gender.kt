package com.example.androiddevchallenge.domain

import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

enum class Gender {
    Female,
    Male;

    val displayResource: Int
        @StringRes get() = when (this) {
            Female -> R.string.all_female
            Male -> R.string.all_male
        }
}