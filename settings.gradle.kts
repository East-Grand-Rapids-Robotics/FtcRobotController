pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}
dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven(url = "https://maven.brott.dev/")
    }
}
rootProject.name = "East Grand Rapids FTC Robot Controller"
include(":FtcRobotController")
include(":TeamCode")
include(":MeepMeepTesting")
