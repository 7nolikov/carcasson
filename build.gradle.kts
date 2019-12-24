plugins {
    idea
    maven

    kotlin("jvm") apply false
    kotlin("plugin.jpa") apply false
    kotlin("plugin.spring") apply false
}

group = "com.carcassonne"
version = "1.0-SNAPSHOT"

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "carcassonne.AppKt"
}
