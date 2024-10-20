package com.example.pnlanalyser

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Set the content view for the activity
        setContent {
            MyApp()
        }
    }


    @Composable
    fun MyApp() {
        val navController = rememberNavController()
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        Box(modifier = Modifier.fillMaxSize()) {
            // Display background image based on current route
            when (currentRoute) {
                "main" -> DisplayBackgroundImage(imageRes = R.drawable.main_bg)
                "Login", "Register" -> DisplayBackgroundImage(imageRes = R.drawable.loginpage)
            }

            // Navigation setup
            NavHost(navController = navController, startDestination = "main") {
                composable("main") {
                    Main(
                        navigateToLoginScreen = { navController.navigate("Login") },
                        navigateToRegisterScreen = { navController.navigate("Register") }
                    )
                }
                composable("Login") {
                    Login(

                        navigateToFirstScreen = { navController.navigate("Dashboard") }  // Navigate to Dashboard after login
                    )
                }
                composable("Register") {
                    Register(
                        navigateToLoginScreen = { navController.navigate("Login") },
                        navigateToFirstScreen = { navController.navigate("Dashboard") }  // Navigate to Dashboard after registration
                    )
                }
                composable("Dashboard") {
                    DashboardPage(
                        navigateToSale = { navController.navigate("Sale") },
                        navigateToPurchase = { navController.navigate("Purchase") }
                    )
                }
                composable("Sale") {
                    SaleEntryScreen(
                        navigateToFirstScreen = { navController.navigate("Dashboard") }
                    )
                }
                composable("Purchase") {
                    PurchaseEntryScreen(
                      
                        navigateToFirstScreen = { navController.navigate("Dashboard") }
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayBackgroundImage(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}