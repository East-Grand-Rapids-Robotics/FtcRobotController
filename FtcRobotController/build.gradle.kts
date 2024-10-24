import java.text.SimpleDateFormat
import java.util.Date

plugins {
    id(libs.plugins.android.library.get().pluginId)
}

dependencies {
    constraints{
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:2.0.20")
    }
    implementation(libs.bundles.ftc)
    implementation(libs.androidx.appcompat)
}

android {
    namespace = "com.qualcomm.ftcrobotcontroller"

    compileSdk = 34

    defaultConfig {
        minSdk = 24
        buildConfigField(
            "String",
            "APP_BUILD_TIME",
            "\"${SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(Date())}\""
        )
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = true
    }
}

