plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding.data.sources.pixabay"

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

    implementation(project(":datasources:api"))
    implementation(Libs.androidxCore)

    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitGsonConverter)
    implementation(Libs.Network.okhttp3)
    implementation(Libs.Network.okhttpBom)
    implementation(Libs.Network.loggingInterceptor)

    implementation(Libs.Room.paging)
    implementation(Libs.Room.ktx)
    kapt(Libs.Room.compiler)

    implementation(Libs.Dagger.android)
    kapt(Libs.Dagger.compiler)
}