package com.example.testcomposeapp.magic8ball

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcomposeapp.ui.utils.conditional
import kotlin.math.sin

@Composable
fun Magic8BallScreen(
    magic8BallViewModel: Magic8BallViewModel
) {
    Magic8BallScreenContent(
        response = magic8BallViewModel.response,
        isLoading = magic8BallViewModel.isLoading,
        onShake = magic8BallViewModel::generateResponse
    )
}


@Composable
fun Magic8BallScreenContent(
    response: String,
    isLoading: Boolean = false,
    onShake: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Magic 8 Ball") })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val infiniteTransition = rememberInfiniteTransition()
            val shakeOffset by infiniteTransition.animateFloat(
                initialValue = -10f,
                targetValue = 10f,
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 100, easing = { time ->
                        sin(time * 6.28f) // creates a smooth shaking effect
                    }),
                    repeatMode = RepeatMode.Reverse
                ), label = "Shaking Animation"
            )

            Text(
                text = response,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
                    .conditional(isLoading) {
                        graphicsLayer(translationX = shakeOffset)
                    }
            )

            Button( onClick = onShake) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = "Shake the Magic 8 Ball"
                )

                AnimatedVisibility(visible = isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colors.onPrimary,
                    )
                }
            }
        }
    }
}



@Preview
@Composable
fun Magic8BallScreenPreview() {
    Magic8BallScreenContent(
        response = "Ask a question",
        onShake = {}
    )
}