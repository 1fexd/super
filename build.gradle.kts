plugins {
    `java-platform`
    `maven-publish`
}

group = "fe.super"
version = "0.0.1"

dependencies {
    constraints {
        api("fe.httpkt:core")
    }
}

gradle.includedBuilds.forEach { includedBuild ->




    println(includedBuild.name)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])

            versionMapping {
//                usage("java-api") {
////                    fromResolutionOf("runtimeClasspath")
//                }
//                usage("java-runtime") {
//                    fromResolutionResult()
//                }
            }
        }
    }
}

