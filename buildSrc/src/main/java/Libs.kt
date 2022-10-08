object Libs {
    private const val lifecycle_version = "2.6.0-alpha02"
    private const val paging_version = "3.1.1"

    const val androidxCore = "androidx.core:core-ktx:1.9.0"
    const val material = "com.google.android.material:material:1.6.1"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val activity = "androidx.activity:activity-ktx:1.6.0"
    const val fragment = "androidx.fragment:fragment-ktx:1.5.3"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

    const val junit = "junit:junit:4.13.2"
    const val extJunit = "androidx.test.ext:junit:1.1.3"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"

    const val glide = "com.github.bumptech.glide:glide:4.14.1"
    const val glideKapt = "com.github.bumptech.glide:compiler:4.14.1"

    const val pagingRuntime = "androidx.paging:paging-runtime:$paging_version"
    const val pagingCommon = "androidx.paging:paging-common-ktx::$paging_version"

    const val timber = "com.jakewharton.timber:timber:5.0.1"

    object Kotlin {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:1.7.20"
    }

    object Dagger {
        private const val version = "2.44"
        const val dagger = "com.google.dagger:dagger:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"

        const val android = "com.google.dagger:dagger-android:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    object Network {
        private const val retrofitVersion = "2.9.0"
        private const val okhttpVersion = "4.10.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitGsonConverter =
            "com.squareup.retrofit2:converter-gson:$retrofitVersion"

        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor"
        const val okhttp3 = "com.squareup.okhttp3:okhttp"
        const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:$okhttpVersion"
    }

    object Room {
        private const val roomVersion = "2.5.0-beta01"
        const val runtime = "androidx.room:room-runtime:$roomVersion"
        const val compiler = "androidx.room:room-compiler:$roomVersion"
        const val ktx = "androidx.room:room-ktx:$roomVersion"
        const val paging = "androidx.room:room-paging:$roomVersion"
    }
}