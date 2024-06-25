plugins {
    `java-platform`
    `maven-publish`
}

group = "fe.super"
version = "0.0.1"

dependencies {
    constraints {
        api("com.gitlab.grrfe.gson-ext:core:16.0.0-gson2-koin3")
        api("org.jsoup:jsoup:1.17.2")
        api("io.insert-koin:koin-core:3.5.6")
        api("com.google.crypto.tink:tink:1.13.0")
        api("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.62")
        api("com.gitlab.grrfe.httpkt:ext-gson:13.0.0-alpha.62")
        api("com.gitlab.grrfe.httpkt:ext-jsoup:13.0.0-alpha.62")

//        api("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.62")
//        api("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.62")
//        api("com.gitlab.grrfe.httpkt:core:13.0.0-alpha.62")
//
//        api("org.jsoup:jsoup:1.17.2")
    }
}

//gradle.includedBuilds.forEach { includedBuild ->
//
//    println(includedBuild.name)
//}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])

//            versionMapping {
//                usage("java-api") {
////                    fromResolutionOf("runtimeClasspath")
//                }
//                usage("java-runtime") {
//                    fromResolutionResult()
//                }
//            }
        }
    }
}

