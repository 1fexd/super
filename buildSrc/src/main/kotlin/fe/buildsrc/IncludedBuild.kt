package fe.buildsrc

import org.gradle.api.Project
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.initialization.IncludedBuildSpec.includedBuild

class IncludedBuild(val name: String) {

}
//data class Substitute(
//    val module: String, val mapsTo: String
//)
//
//infix fun String.mapsTo(target: String): Substitute {
//    return Substitute(this, target)
//}
//
//fun substituteOf(vararg substitutes: Substitute): Set<Substitute> {
//    return setOf(*substitutes)
//}

val test = IncludedBuild("gson-ext")

fun test(gradle: Gradle) {
    val dir = gradle.includedBuild("gson-ext").projectDir
    val tasks = gradle.includedBuilds.map {
        it.task(":build")
    }

    println(tasks)

//    gradle.includedBuilds
//    settings.includedBuild("gson-ext")
//    settings.findProject()
}

//val includes = mapOf(
//    "gson-ext" to substituteOf("com.gitlab.grrfe.gson-ext:core" mapsTo ":core"),
//    "uriparser" to substituteOf("com.github.1fexd:uriparser" mapsTo ":"),
//    "tld-lib" to substituteOf("com.github.1fexd:tld-lib" mapsTo ":"),
//    "signify" to substituteOf("com.github.1fexd.signifykt:lib" mapsTo ":lib"),
//    "koin-helper" to substituteOf("com.gitlab.grrfe:koin-helper" mapsTo ":"),
//    "kotlin-reflect-helper" to substituteOf("com.gitlab.grrfe:kotlin-reflect-helper" mapsTo ":"),
//    "kotlin-ext" to substituteOf("com.gitlab.grrfe.kotlin-ext:lib" mapsTo ":lib"),
//    "httpkt" to substituteOf("com.gitlab.grrfe.httpkt:core" mapsTo ":core"),
//)
//
//fun DependencySubstitutions.register(substitutes: Set<Substitute>) {
//    for ((module, target) in substitutes) {
//        substitute(module(module)).using(project(target))
//    }
//}
//
//for ((dir, substitutes) in includes) {
//    includeBuild(dir) {
//        dependencySubstitution {
//            register(substitutes)
//        }
//    }
//}
