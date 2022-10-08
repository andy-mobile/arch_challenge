plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.core.ui"

    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }
}

dependencies {
    implementation(Libs.material)
    implementation(Libs.androidxCore)

    implementation(Libs.Dagger.dagger)
    kapt(Libs.Dagger.compiler)
}