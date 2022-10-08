plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("android")
    kotlin("kapt")
}

kapt.useBuildCache = true

android {
    namespace = "com.example.coding.images"

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
    implementation(Libs.pagingRuntime)
    implementation(Libs.constraintlayout)
    implementation(Libs.material)
    implementation(Libs.viewModelKtx)

    implementation(Libs.glide)
    kapt(Libs.glideKapt)

    implementation(project(":common"))
    implementation(project(":core-sdk"))
    implementation(project(":core-ui"))
    implementation(project(":datasources"))

    implementation(Libs.fragment)

    implementation(Libs.Dagger.android)
    kapt(Libs.Dagger.compiler)
}