plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.datasources"

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
    implementation(project(":datasources:pixabay"))
    api(project(":datasources:api"))

    kapt(Libs.Dagger.compiler)
}