package com.example.testcomposeapp.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcomposeapp.ui.theme.TestComposeAppTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
) {
    LoginScreen(
        name = loginViewModel.name,
        email = loginViewModel.email,
        onNameChanged = loginViewModel::onNameChanged,
        onEmailChanged = loginViewModel::onEmailChanged,
        onContinue = loginViewModel::validateEmail
    )
}

@Composable
private fun LoginScreen(
    name: String = "",
    email: String = "",
    onNameChanged: (String) -> Unit = {},
    onEmailChanged: (String) -> Unit = {},
    onContinue: () -> Unit = {},
) {
    val scrollState = rememberLazyListState()

    TestComposeAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = "Home"
                    )
                })
            },
            content = { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    // Name
                    TextField(
                        value = name,
                        onValueChange = { onNameChanged(it) },
                        label = { Text(text = "Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        shape = RoundedCornerShape(10.dp)
                    )

                    // Email
                    TextField(
                        value = email,
                        onValueChange = onEmailChanged,
                        label = { Text(text = "Email") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        shape = RoundedCornerShape(10.dp)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(20.dp),
                        state = scrollState,
                        content = {
                        itemsIndexed((0..100).toList()) { index, _ ->
                            val isHighlighted by remember { derivedStateOf { scrollState.firstVisibleItemIndex + 3 == index } }
                            ListItem(isHighlighted, index)
                        }
                    })

                    Button(
                        onClick = { onContinue() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(text = "Continue", modifier = Modifier.padding(5.dp))
                    }
                }
            }
        )
    }
}

@Composable
private fun ListItem(
    isHighlighted: Boolean,
    index: Int,
) {
    if (isHighlighted) {
        Text(
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.primary,
            text = "Item $index")
    } else {
        Text(text = "Item $index")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    LoginScreen()
}
