plugins {
    `java-platform`
    `maven-publish`
    id("net.nemerosa.versioning") version "3.1.0"
}

group = "fe.super"
version = versioning.info.tag ?: versioning.info.full

dependencies {
    constraints {
        api("com.google.code.gson:gson:2.11.0")
        api("com.gitlab.grrfe.gson-ext:core:16.0.0-gson2-koin3")
        api("com.gitlab.grrfe.gson-ext:koin:16.0.0-gson2-koin3")
        api("com.github.1fexd:uriparser:0.0.11")
        api("com.github.1fexd:tld-lib:2.1.0")
        api("com.github.1fexd.signifykt:lib:0.0.5")
        api("com.gitlab.grrfe.kotlin-ext:lib:0.0.59")
        api("com.gitlab.grrfe:kotlin-reflect-helper:0.0.1")
        api("com.gitlab.grrfe.koin-helper:api:6.0.0")
        api("org.jsoup:jsoup:1.17.2")
        api("org.apache.httpcomponents.core5:httpcore5:5.3-alpha1")
        api("io.insert-koin:koin-core:3.5.6")
        api("org.jetbrains.kotlinx:kotlinx-cli-jvm:0.3.6")
    }
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "platform"
    from(components["javaPlatform"])
}
