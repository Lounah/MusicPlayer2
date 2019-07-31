object ApplicationId {
    val id = "io.lounah.musicplayer2"
}

object Modules {
    val app = ":app"
    val core = ":core"
}

object Releases {
    val versionCode = 1
    val versionName = "0.0.1"
}

object Versions {
    val gradle = "3.4.2"
    val compileSdk = 29
    val minSdk = 19
    val targetSdk = 29
    val appcompat = "1.0.2"
    val design = "1.0.0"
    val recyclerview = "1.0.0"
    val ktx = "1.0.0-alpha1"
    val ktLint = "0.24.0"
    val rxjava = "2.2.8"
    val rxkotlin = "2.3.0"
    val lifecycle = "2.0.0"
    val kotlin = "1.3.41"
    val constraintLayout = "1.1.2"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
}