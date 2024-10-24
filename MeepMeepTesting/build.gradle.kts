plugins {
    id("java-library")
    id(id = "org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    constraints{
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common:2.0.20")
    }
    implementation(libs.meepmeep)
}