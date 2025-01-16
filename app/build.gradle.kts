plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")

}

android {
    namespace = "com.example.pnlanalyser"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pnlanalyser"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
    // Coroutine support
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    // Room dependencies
    implementation("androidx.room:room-runtime:2.5.0")
    implementation(libs.firebase.firestore.ktx) // Use the latest version
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0") // For coroutine support
    androidTestImplementation("androidx.room:room-testing:2.5.0")

    // Compose dependencies
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.1.0") // Use the latest version for Material3
    implementation("androidx.compose.material:material-icons-extended:1.5.0") // Use the latest version
    implementation(platform(libs.androidx.compose.bom))

    // Navigation Component
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9") // or latest stable version
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9") // or latest stable version
    val room_version = "2.5.0"

    implementation ("androidx.room:room-runtime:$room_version")
    kapt ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")

    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Use the latest version
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1") // Use the latest version

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0") // Use the latest version
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0") // Use the latest version

    // SQLite JDBC (not typically used in Android)
    // If you need SQLite in an Android project, consider using Room's built-in SQLite support
    // implementation("org.xerial.sqlite-jdbc:sqlite-jdbc:3.36.0.3")

    // Other dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
