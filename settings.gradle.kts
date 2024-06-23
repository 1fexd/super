rootProject.name = "super"

//pluginManagement {
//    repositories {
//        mavenLocal()
//    //        gradlePluginPortal()
//    }
//
//    plugins {
//        kotlin("jvm") version "1.9.24"
//        id("de.fayard.refreshVersions") version "0.60.1"
//        id("org.gradle.maven-publish")
//        id("net.nemerosa.versioning") version "3.1.0"
//    }
//}
//
//plugins {
//    kotlin("jvm") apply false
//    id("de.fayard.refreshVersions") apply false
//    id("net.nemerosa.versioning") apply false
//}

val excludes = setOf(
    "gradle", "buildSrc",
//    "bom"
//    "clearurl",
//    "gson-ext",
//    "uriparser"
//,"koin-exposed"
)
//
//includeBuild("clearurl") {
//    dependencySubstitution {
//        substitute(module("com.github.1fexd:clearurlkt")).using(project(":"))
//    }
//}

data class Substitute(
    val module: String, val mapsTo: String
)

infix fun String.mapsTo(target: String): Substitute {
    return Substitute(this, target)
}

fun substituteOf(vararg substitutes: Substitute): Set<Substitute> {
    return setOf(*substitutes)
}


val includes = mapOf(
    "gson-ext" to substituteOf("com.gitlab.grrfe.gson-ext:core" mapsTo ":core"),
    "uriparser" to substituteOf("com.github.1fexd:uriparser" mapsTo ":"),
    "tld-lib" to substituteOf("com.github.1fexd:tld-lib" mapsTo ":"),
    "signify" to substituteOf("com.github.1fexd:signifykt" mapsTo ":"),
    "koin-helper" to substituteOf("com.gitlab.grrfe:koin-helper" mapsTo ":"),
    "kotlin-reflect-helper" to substituteOf("com.gitlab.grrfe:kotlin-reflect-helper" mapsTo ":"),
    "kotlin-ext" to substituteOf("com.gitlab.grrfe:kotlin-ext" mapsTo ":"),
    "httpkt" to substituteOf("com.gitlab.grrfe.httpkt:core" mapsTo ":core"),
)

fun DependencySubstitutions.register(substitutes: Set<Substitute>) {
    for ((module, target) in substitutes) {
        substitute(module(module)).using(project(target))
    }
}

for ((dir, substitutes) in includes) {
    includeBuild(dir) {
        dependencySubstitution {
            register(substitutes)
        }
    }
}

rootProject.projectDir.listFiles()
    ?.filter { it.name !in includes }
    ?.filter { it.name !in excludes }
    ?.filter { it.isDirectory }
    ?.filter { !it.name.startsWith(".") }
    ?.forEach { includeBuild(it) }

//include("bom")
