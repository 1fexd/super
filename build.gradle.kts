plugins {
    id("net.nemerosa.versioning") version "3.1.0"
}

group = "fe.super"
version = versioning.info.tag ?: versioning.info.full
