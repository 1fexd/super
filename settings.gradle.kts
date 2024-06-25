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


//pluginManagement {
//    includeBuild("plugin")
//}

//plugins {
//    id("plugin")
//}

val excludes = setOf(
    "gradle", "buildSrc",
    "platform"
//    "bom"
//    "clearurl",
//    "gson-ext",
//    "uriparser"
//,"koin-exposed"
)

data class Substitute(
    val module: String, val mapsTo: String
)

@JvmInline
value class Owner(private val name: String) {
    fun join(repo: String, module: String? = null): String {
        if (module == null) {
            return "$name:$repo"
        }

        return "$name.$repo:$module"
    }
}

class Included(
    private val projectDir: String,
    private vararg val modules: String
) {
    fun substitutes(owner: Owner, name: String = projectDir): Pair<String, List<Substitute>> {
        return projectDir to build(owner, name)
    }

    private fun build(owner: Owner, name: String): List<Substitute> {
        if (modules.isEmpty()) {
            return listOf(Substitute(owner.join(name), ":"))
        }

        return modules.map {
            Substitute(owner.join(name, it), ":$it")
        }
    }
}

val _1fexd = Owner("com.github.1fexd")
val grrfe = Owner("com.gitlab.grrfe")

val includes = mapOf(
    Included("gson-ext", "core", "koin").substitutes(grrfe),
    Included("uriparser").substitutes(_1fexd, "uri-parser"),
    Included("tld-lib").substitutes(_1fexd),
    Included("signify", "lib").substitutes(_1fexd, "signifykt"),
    Included("koin-helper", "api", "core").substitutes(grrfe),
    Included("kotlin-reflect-helper").substitutes(grrfe),
    Included("kotlin-ext", "lib").substitutes(grrfe),
    Included("httpkt", "core", "ext-gson", "ext-jsoup").substitutes(grrfe)
)

fun DependencySubstitutions.register(substitutes: List<Substitute>) {
    for ((module, target) in substitutes) {
        println("$module for $target")
        substitute(module(module)).using(project(target))
    }
}

var isJitPack = System.getenv("JITPACK")?.toBooleanStrictOrNull() == true

if (isJitPack) {
    include("platform")
} else {
    includeBuild("platform") {
        dependencySubstitution {
            substitute(module("com.github.1fexd:super")).using(project(":"))
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
}
