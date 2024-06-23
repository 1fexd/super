plugins {
    `java-platform`
    `maven-publish`
}

group = "fe.super"
version = "0.0.1"

dependencies {
    constraints {
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

