import org.gradle.api.tasks.JavaExec

plugins {
    kotlin("jvm") version "2.4.20"
}

group = "com.buenosdev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    // Kotlin files currently live alongside the Java files in this repository.
    sourceSets {
        main {
            kotlin.srcDirs("src/main/java")
        }
        test {
            kotlin.srcDirs("src/test/java")
        }
    }

    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runContainsDuplicate") {
    group = "application"
    description = "Run the Contains Duplicate Java example."
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.buenosdev.arraymatrix.containsduplicate.ProblemSolution")
}

tasks.register<JavaExec>("runTrieKotlin") {
    group = "application"
    description = "Run the Kotlin Trie example."
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("com.buenosdev.trie.TrieKotlinKt")
}
