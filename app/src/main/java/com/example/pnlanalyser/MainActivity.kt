package com.example.pnlanalyser

import AppDatabase
import UserViewModel
import UserViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.pnlanalyser.ui.theme.PnlAnalyserTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Room database
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "planalyser-database"
        ).build()

        enableEdgeToEdge()
        setContent {
            // Pass the database to MyApp
            MyApp(db)
        }
    }
}

@Composable
fun MyApp(db: AppDatabase) {
    val navController = rememberNavController()

    // Initialize the ViewModel using the factory
    val userDao = db.userDao()
    val userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(userDao))

    // Fetch user data when the app starts
    userViewModel.fetchUser()

    // Observe user data with LiveData
    val user by userViewModel.user.observeAsState() // Initialize to null

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

        // Display user information or a message if not found
        if (user != null) {
            // User found, display user information
            Text(
                text = "Welcome, ${user.username}!",
                modifier = Modifier.padding(16.dp)
            )
        } else {
            // No user found, display a message or any other UI element
            Text(
                text = "No user found.",
                modifier = Modifier.padding(16.dp)
            )
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
                Login(db) {
                    navController.navigate("Dashboard")  // Navigate to Dashboard after login
                }
            }
            composable("Register") {
                Register(
                    db,
                    navigateToLoginScreen = { navController.navigate("Login") },
                    navigateToFirstScreen = { navController.navigate("Dashboard") }  // Navigate to Dashboard after registration
                )
            }
            composable("Dashboard") {
                dashboardPage {}
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
