plugins {
    id(libs.plugins.kotlin.android.get().pluginId)
    id("ftc.convention")
}

kotlin {
    version = "2.0.20"
}

android {
    namespace = "org.firstinspires.ftc.teamcode.intothedeep"
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packaging {
        jniLibs {
            pickFirsts += listOf("**/*.so")
            useLegacyPackaging = true
        }
    }
}

dependencies {
    constraints{
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:2.0.20")
    }
    implementation(libs.bundles.ftc)
    implementation(project(":FtcRobotController"))
//    implementation(libs.si.units)
    implementation(libs.commons.math3)
    implementation(libs.jackson.databind)
    implementation(libs.roadrunner)
    implementation(libs.acme.dashboard)
    implementation(libs.androidx.appcompat)

}
