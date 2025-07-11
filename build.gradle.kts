plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.serialization") version "2.2.0"
    application
}

application {
    mainClass.set("org.example.MainKt")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val arrowVersion = "2.1.2"
val kotlinxSerializationVersion = "1.9.0"
val kotestVersion = "5.9.1"
val arrowAssertionsVersion = "2.0.0"

dependencies {
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest.extensions:kotest-assertions-arrow:$arrowAssertionsVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}