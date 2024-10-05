package com.example.pnlanalyser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pnlanalyser.ui.theme.PnlAnalyserTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PnlAnalyserTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp()

                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Box(modifier = Modifier.fillMaxSize()) {
        when (currentRoute) {
            "main" -> {
                Image(
                    painter = painterResource(id = R.drawable.main_bg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            "Login" -> {
                Image(
                    painter = painterResource(id = R.drawable.loginpage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            "Register"->{
                Image(
                    painter = painterResource(id = R.drawable.loginpage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                Main(
                    navigateToLoginScreen = { navController.navigate("Login") },
                    navigateToRegisterScreen = { navController.navigate("Register") }
                )
            }
            composable("Login") {
                Login {
                    navController.navigate("Dashboard")
                }
            }
            composable("Register") {
                Register (
                    navigateToLoginScreen = { navController.navigate("Login") },
                    navigateToFirstScreen =  { navController.navigate("Dashboard") }
                )
            }
            composable("Dashboard") {
                dashboardPage {}
            }
        }
    }
}
