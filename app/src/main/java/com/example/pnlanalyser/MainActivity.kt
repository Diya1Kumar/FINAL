package com.example.pnlanalyser
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image logic based on current route
        val currentBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = currentBackStackEntry.value?.destination?.route

        when (currentRoute) {
            "main" -> {
                DisplayBackgroundImage(imageRes = R.drawable.main_bg)
            }
            "Login", "Register" -> {
                DisplayBackgroundImage(imageRes = R.drawable.loginpage)
            }
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
                Login() { // Commenting out db argument for now
                    navController.navigate("Dashboard")  // Navigate to Dashboard after login
                }
            }
            composable("Register") {
                Register(
                    navigateToLoginScreen = { navController.navigate("Login") },
                    navigateToFirstScreen = { navController.navigate("Dashboard") }  // Navigate to Dashboard after registration
                )
            }
            composable("Dashboard") {
                DashboardPage(
                    navigateToPurchase = { navController.navigate("Purchase")},
                    navigateToSale = {navController.navigate("Sale")}
                )
            }
            composable("Purchase"){
                PurchaseEntryScreen(
                    navigateToPurchase = {navController.navigate("Purchase")},
                    navigateToFirstScreen = {navController.navigate("Dashboard")}
                )
            }
            composable("Sale"){
                SaleEntryScreen(
                    navigateToSale = {navController.navigate("Sale")},
                    navigateToFirstScreen = {navController.navigate("Dashboard")}
                )
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
