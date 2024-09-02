package com.example.pnlanalyser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Login(navigateToFirstScreen:()->Unit){
    val username = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = false),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = "Login",
                style = TextStyle(
                    fontFamily = Kurale,
                    color = Color.White,
                    fontSize = 70.sp
                ),
                modifier = Modifier.padding(top = 200.dp,end = 50.dp)// Optional: Add padding to the end
            )
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(26.dp))
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
                placeholder = { Text(text = "Username") })
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
        ){
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            placeholder = { Text(text = "Password") })
    }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {navigateToFirstScreen()}, modifier = Modifier.padding(0.dp).background(color = Color.White)) {
            Text(text = "login")
    }

    }

        

}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.loginpage), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Login({})
    }
}