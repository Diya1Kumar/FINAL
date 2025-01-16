package com.example.pnlanalyser


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun Login(
    navigateToFirstScreen: () -> Unit,
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontFamily = Kurale,  // Replace with your font
                    color = Color.White,
                    fontSize = 70.sp
                ),
                modifier = Modifier.padding(top = 140.dp, end = 50.dp)
            )
        }

        // Input Fields
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(26.dp))

            // Username Field
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                singleLine = true,
                placeholder = { Text(text = "Username") },
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                singleLine = true,
                placeholder = { Text(text = "Password") },
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Login Button
            Button(
                onClick = {
                    navigateToFirstScreen()
                },
                enabled = !isLoading,
                modifier = Modifier.padding(8.dp) // Optional padding for the button
            ) {
                Text(text = if (isLoading) "Loading..." else "Login")
            }
        }
    }
}
