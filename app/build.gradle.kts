plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "pgm.poolp.blocages"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "pgm.poolp.blocages"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.coreAndroidX)
    implementation (Dependencies.lifecycleRuntime)
    implementation (Dependencies.activityCompose)
    implementation (Dependencies.iconsExtended)
    implementation (Dependencies.composeUi)
    implementation (Dependencies.composeUiToolingPreview)
    implementation (Dependencies.composeMaterial3)
    implementation (Dependencies.composeMaterial)
    implementation (Dependencies.composeAnimation)

    implementation (Dependencies.constraintLayout)

    implementation (Dependencies.lifecycleViewModelCompose)

    testImplementation (Dependencies.junit)

    androidTestImplementation (Dependencies.androidTestJunit)
    androidTestImplementation (Dependencies.androidTestEspresso)

    androidTestImplementation (Dependencies.composeUiTestJUnit4)
    debugImplementation (Dependencies.composeUiTestTooling)
    debugImplementation (Dependencies.composeUiTestManifest)

    implementation (Dependencies.hiltAndroid)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation (Dependencies.hiltNavigationCompose)
    implementation (Dependencies.navigationCompose)

    implementation (Dependencies.pagingCompose)
    implementation (Dependencies.coilCompose)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}