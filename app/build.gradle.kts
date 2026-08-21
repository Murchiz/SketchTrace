import java.util.Properties
import java.io.FileInputStream

plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.compose)
}

android {
  namespace = "com.example"
  compileSdk {
    version = release(37)
  }

  defaultConfig {
    applicationId = "com.murchiz.sketchtrace"
    minSdk = 31
    targetSdk = 36
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    proguardFiles()
  }

  signingConfigs {
      // All signing credentials are loaded from environment variables or local.properties.
      // Do NOT hardcode passwords here.
      val localProperties = Properties()
      val localPropertiesFile = rootProject.file("local.properties")
      if (localPropertiesFile.exists()) {
          FileInputStream(localPropertiesFile).use { localProperties.load(it) }
      }

      val storePwd = System.getenv("STORE_PASSWORD")
          ?: localProperties.getProperty("STORE_PASSWORD")
          ?: rootProject.findProperty("STORE_PASSWORD") as? String
      val keyPwd = System.getenv("KEY_PASSWORD")
          ?: localProperties.getProperty("KEY_PASSWORD")
          ?: rootProject.findProperty("KEY_PASSWORD") as? String

      val keystoreFile = file("${rootDir}/key.jks")

      if (keystoreFile.exists() && storePwd != null && keyPwd != null) {
          getByName("debug") {
              keyAlias = "upload"
              storeFile = keystoreFile
              storePassword = storePwd
              keyPassword = keyPwd
          }

          create("release") {
              storeFile = keystoreFile
              keyAlias = "upload"
              storePassword = storePwd
              keyPassword = keyPwd
          }
      }
  }

  buildTypes {
    release {
      isCrunchPngs = false
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      signingConfigs.findByName("release")?.let {
          signingConfig = it
      }
    }
    debug {
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlin {
    jvmToolchain(17)
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  testOptions { unitTests { isIncludeAndroidResources = true } }
  buildToolsVersion = "37.0.0"
}

dependencies {
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.accompanist.permissions)
  implementation(libs.androidx.activity.compose)
  implementation(libs.androidx.camera.camera2)
  implementation(libs.androidx.camera.core)
  implementation(libs.androidx.camera.lifecycle)
  implementation(libs.androidx.camera.view)
  implementation(libs.androidx.compose.material.icons.core)
  implementation(libs.androidx.compose.material.icons.extended)
  implementation(libs.androidx.compose.material3)
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.compose)
  implementation(libs.coil.compose)
  testImplementation(libs.androidx.core)
  testImplementation(libs.androidx.junit)
  testImplementation(libs.junit)
  testImplementation(libs.robolectric)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.runner)
}
