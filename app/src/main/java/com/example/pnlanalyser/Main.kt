package com.example.pnlanalyser

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Kurale = FontFamily(
    Font(R.font.kurale_regular, FontWeight.Normal)
)

@Composable
fun Main(navigateToLoginScreen:()->Unit, navigateToRegisterScreen:()->Unit){
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "PnL Analyser",
            style = TextStyle(
                fontFamily = Kurale,
                fontSize = 50.sp
            )
        )
        Row {
            TextButton(onClick = {navigateToLoginScreen()},
                modifier = Modifier.padding(0.dp))
                {
                    Text(text = "Login", modifier = Modifier.padding(horizontal = 0.dp), color = Color(0xFF4D4DE5), style = TextStyle(textDecoration = TextDecoration.Underline))

                }
            Text(text = "or",modifier = Modifier.padding(horizontal = 0.dp, vertical = 11.dp))
            TextButton(onClick = {
                navigateToRegisterScreen()
            }, modifier = Modifier.padding(0.dp)){
                Text(text = "Register",modifier = Modifier.padding(horizontal = 0.dp), color = Color(0xFF4D4DE5), style = TextStyle(textDecoration = TextDecoration.Underline))

            }
            Text(text = "with us",modifier = Modifier.padding(horizontal = 0.dp, vertical = 11.dp))

        }

    }

}


@Preview(showBackground = true)
@Composable
fun  MainPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.main_bg), // Replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Main(navigateToLoginScreen = {}, navigateToRegisterScreen = {})

    }
}