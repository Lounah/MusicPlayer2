object ApplicationId {
    const val id = "io.lounah.musicplayer2"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val mediaBrowser = ":mediabrowser"
    const val widget = ":widget"
}

object Releases {
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Versions {
    const val gradle = "3.4.2"
    const val compileSdk = 29
    const val minSdk = 19
    const val targetSdk = 29
    const val appcompat = "1.0.2"
    const val design = "1.0.0"
    const val recyclerview = "1.0.0"
    const val ktx = "1.0.0-alpha1"
    const val ktLint = "0.24.0"
    const val rxjava = "2.2.8"
    const val rxkotlin = "2.3.0"
    const val lifecycle = "2.0.0"
    const val kotlin = "1.3.41"
    const val constraintLayout = "1.1.2"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object SupportLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.design}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
}