import java.util.regex.Pattern

plugins {
    id("com.android.application")
}


android {
    compileSdk = 35

    signingConfigs {
        create("release") {
            val apkStoreFile = System.getenv("APK_SIGNING_STORE_FILE")
            if (apkStoreFile != null) {
                keyAlias = System.getenv("APK_SIGNING_KEY_ALIAS")
                keyPassword = System.getenv("APK_SIGNING_KEY_PASSWORD")
                storeFile = file(System.getenv("APK_SIGNING_STORE_FILE"))
                storePassword = System.getenv("APK_SIGNING_STORE_PASSWORD")
            } else {
                keyAlias = "androiddebugkey"
                keyPassword = "android"
                storeFile = rootProject.file("libs/ftc.debug.keystore")
                storePassword = "android"
            }
        }
        getByName("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = rootProject.file("libs/ftc.debug.keystore")
            storePassword = "android"
        }
    }
    defaultConfig {
        signingConfig = signingConfigs.getByName("debug")
        minSdk = 24
        compileSdk = 34
        lint.targetSdk = 29

        val manifestFile = project(":FtcRobotController").file("src/main/AndroidManifest.xml")
        val manifestText = manifestFile.readText()
        val vCodePattern = Pattern.compile("versionCode=\"(\\d+(\\.\\d+)*)\"")
        var matcher = vCodePattern.matcher(manifestText)
        matcher.find()
        val vCode = Integer.parseInt(matcher.group(1))
        val vNamePattern = Pattern.compile("versionName=\"(.*)\"")
        matcher = vNamePattern.matcher(manifestText)
        matcher.find()
        val vName = matcher.group(1)

        versionCode = vCode
        versionName = vName

    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            ndk {
                abiFilters.addAll(setOf("armeabi-v7a", "arm64-v8a"))
            }
        }
        getByName("debug") {
            isJniDebuggable = true
            ndk {
                abiFilters.addAll(setOf("armeabi-v7a", "arm64-v8a"))
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets.getByName("main") {
//        jniLibs {
//            srcDir(rootProject.file())
//        }
    }
    ndkVersion = "21.3.6528147"
}