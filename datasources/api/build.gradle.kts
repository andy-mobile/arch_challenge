plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.data.sources.api"

    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(Libs.Room.paging)
}