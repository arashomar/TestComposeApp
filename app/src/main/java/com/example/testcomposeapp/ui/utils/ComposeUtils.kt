package com.example.testcomposeapp.ui.utils

import androidx.compose.ui.Modifier

fun Modifier.conditional(
    condition: Boolean,
    block: Modifier.() -> Modifier
): Modifier {
    return if (condition) {
        block(this)
    } else {
        this
    }
}