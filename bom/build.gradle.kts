plugins {
    `java-platform`
    `maven-publish`
}

dependencies {
    constraints {
        api("fe.httpkt:core")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
        }
    }
}

