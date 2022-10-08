plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.coding"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.example.coding"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    kapt {
        useBuildCache = true
        correctErrorTypes = true
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }

    packagingOptions {
        resources.excludes += "DebugProbesKt.bin"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":core-ui"))
    implementation(project(":core-sdk"))
    implementation(project(":feature-images"))

    implementation(Libs.material)
    implementation(Libs.constraintlayout)

    implementation(Libs.Dagger.dagger)

    implementation(Libs.timber)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.espressoCore)

    kapt(Libs.Dagger.compiler)
    kapt(Libs.Dagger.androidProcessor)
}
