package com.example.pnlanalyser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Register(navigateToLoginScreen: () -> Unit) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

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
        )
        {
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Register",
                style = TextStyle(
                    fontFamily = Kurale,
                    color = Color.White,
                    fontSize = 60.sp

                ),
                modifier = Modifier.padding(top = 220.dp, end= 50.dp)
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
            Box(
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp)) // Shadow applied here
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(12.dp)
                    ) // Background color and shape
                    .padding(0.dp)
            ) {
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                placeholder = { Text(text = "Username") },
                shape = RoundedCornerShape(12.dp)// Placeholder for username
            )
        }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp)) // Shadow applied here
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(12.dp)
                    ) // Background color and shape
                    .padding(0.dp)
            ) {
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = { Text(text = "Email") },
                shape = RoundedCornerShape(12.dp)// Placeholder for password
            )
        }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp)) // Shadow applied here
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(12.dp)
                    ) // Background color and shape
                    .padding(0.dp)
                    .background(color = Color.White)
            ) {
                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    placeholder = { Text(text = "Create Password") },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.background(Color.White, shape = RoundedCornerShape(12.dp)))// Placeholder for password

            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {navigateToLoginScreen()}) {
                Text(text = "Register")
                
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

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.loginpage), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Register({})
    }
}
