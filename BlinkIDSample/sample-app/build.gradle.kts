plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.microblink.blinkid.sample"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.microblink.blinkid.sample"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":lib-common"))
    implementation(libs.blinkid.ux)
    // use following set of dependencies if you want to use blinkid-ux library module
    // instead of maven dependency, and remove implementation(libs.blinkid.ux) dependency
//     implementation(project(":blinkid-ux"))
}