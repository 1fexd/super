rootProject.name = "super"

//pluginManagement {
//    repositories {
//        mavenLocal()
//        maven(url = "https://jitpack.io")
//        gradlePluginPortal()
//    }
//
//    plugins {
//        kotlin("jvm") version "1.9.24"
//        id("de.fayard.refreshVersions") version "0.60.1"
//        id("org.gradle.maven-publish")
//        id("net.nemerosa.versioning") version "3.0.0"
//    }
//}
//
//plugins {
//    kotlin("jvm") apply false
//    id("de.fayard.refreshVersions") apply false
//    id("net.nemerosa.versioning") apply false
//}

val excludes = setOf("gradle")

rootProject.projectDir.listFiles()
    ?.filter { it.isDirectory && !it.name.startsWith(".") && it.name !in excludes }
    ?.forEach { includeBuild(it) }
