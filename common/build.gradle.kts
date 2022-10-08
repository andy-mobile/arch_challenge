plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.common"

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
    implementation(Libs.androidxCore)
    implementation(Libs.Kotlin.coroutines)
    implementation(Libs.lifecycleKtx)
    implementation(Libs.fragment)
    implementation(Libs.material)

    implementation(Libs.Dagger.dagger)
    kapt(Libs.Dagger.compiler)
}