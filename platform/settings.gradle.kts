dependencyResolutionManagement {
    versionCatalogs {
        create("externalLibs").from(files("../gradle/external_libs.versions.toml"))
        create("libs").from(files("../gradle/versions.toml"))
    }
}
