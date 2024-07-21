plugins {
    `java-platform`
    `maven-publish`
    id("net.nemerosa.versioning") version "3.1.0"
}

group = "fe.super"
version = versioning.info.tag ?: versioning.info.full

dependencies {
    constraints {
        api(externalLibs.gson)
        api(externalLibs.jsoup)
        api(externalLibs.koinCore)
        api(externalLibs.kotlinxCliJvm)
        api(externalLibs.apacheHttpComponentsCore)

        api(libs.gsonExtCore)
        api(libs.gsonExtKoin)
        api(libs.uriparser)
        api(libs.tldLib)
        api(libs.signify)
        api(libs.kotlinExt)
        api(libs.kotlinReflectHelper)
        api(libs.koinHelper)
    }
}

publishing.publications.create<MavenPublication>("maven") {
    artifactId = "platform"
    from(components["javaPlatform"])
}
