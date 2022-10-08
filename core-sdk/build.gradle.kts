plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.core.sdk"

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
    implementation(Libs.androidxCore)
    implementation(Libs.Kotlin.coroutines)

    implementation(Libs.Dagger.dagger)
    kapt(Libs.Dagger.compiler)
}