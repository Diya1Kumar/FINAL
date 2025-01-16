package com.example.pnlanalyser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pnlanalyser.network.RegisterRequest
import com.example.pnlanalyser.network.RetrofitClient
import retrofit2.Call

@Composable
fun Register(
    navigateToLoginScreen: () -> Unit,
    navigateToFirstScreen: () -> Unit,
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = false),
            contentAlignment = Alignment.TopEnd
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Register",
                style = TextStyle(
                    fontFamily = Kurale,
                    color = Color.White,
                    fontSize = 60.sp
                ),
                modifier = Modifier.padding(top = 180.dp, end = 50.dp)
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Username field
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                placeholder = { Text(text = "Username") },
                singleLine = true,
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Email field
//            TextField(
//                value = email.value,
//                onValueChange = { email.value = it },
//                placeholder = { Text(text = "Email") },
//                singleLine = true,
//                modifier = Modifier
//                    .shadow(8.dp, RoundedCornerShape(12.dp))
//                    .background(Color.White, shape = RoundedCornerShape(12.dp))
//            )
//            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                placeholder = { Text(text = "Create Password") },
                singleLine = true,
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    isLoading = true
                    errorMessage = ""

                    // Call Retrofit API to register user
                    val registerRequest = RegisterRequest(username.value, password.value)
                    RetrofitClient.apiService.register(registerRequest).enqueue(object : retrofit2.Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: retrofit2.Response<Void>) {
                            if (response.isSuccessful) {
                                navigateToFirstScreen() // Navigate after successful registration
                            } else {
                                errorMessage = "Registration failed"
                            }
                            isLoading = false
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            errorMessage = "Error: ${t.message}"
                            isLoading = false
                        }
                    })
                },
                enabled = !isLoading
            ) {
                Text(text = if (isLoading) "Loading..." else "Register")
            }

            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Already have an account?", style = TextStyle(textAlign = TextAlign.Center))
                TextButton(onClick = { navigateToLoginScreen() }) {
                    Text(
                        text = "Login",
                        modifier = Modifier.padding(horizontal = 0.dp),
                        color = Color(0xFF4D4DE5),
                        style = TextStyle(textDecoration = TextDecoration.Underline)
                    )
                }
            }
        }
    }
}
