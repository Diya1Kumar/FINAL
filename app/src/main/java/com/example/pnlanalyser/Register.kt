package com.example.pnlanalyser

//import AppDatabase
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Register(
    // db: AppDatabase, // Commenting out the db argument for now
    navigateToLoginScreen: () -> Unit,
    navigateToFirstScreen: () -> Unit
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    // State for error message
    val errorMessage = remember { mutableStateOf("") }

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
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Register",
                style = TextStyle(
                    fontFamily = Kurale,
                    color = Color.White,
                    fontSize = 60.sp
                ),
                modifier = Modifier.padding(top = 220.dp, end = 50.dp)
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
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                placeholder = { Text(text = "Email") },
                singleLine = true,
                modifier = Modifier
                    .shadow(8.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))

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

            // Error message
            if (errorMessage.value.isNotEmpty()) {
                Text(text = errorMessage.value, color = Color.Red)
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Register button
            Button(onClick = {
                if (username.value.isNotBlank() && email.value.isNotBlank() && password.value.isNotBlank()) {
                    // Register the user in the database (commented out)
                    /*
                    CoroutineScope(Dispatchers.IO).launch {
                        val user = User(username = username.value, email = email.value, password = password.value)
                        db.userDao().insert(user)

                        // Navigate to the first screen on success
                        withContext(Dispatchers.Main) {
                            navigateToFirstScreen()
                        }
                    }
                    */
                } else {
                    // Display error message if fields are empty
                    errorMessage.value = "All fields must be filled out"
                }
            }) {
                Text(text = "Register")
            }

            // Navigate to login screen
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
        // Use a mock or in-memory database instance for preview
        Register(
            // db = Room.inMemoryDatabaseBuilder(LocalContext.current, AppDatabase::class.java).build(), // Commented out for now
            navigateToLoginScreen = {},
            navigateToFirstScreen = {}
        )
    }
}
