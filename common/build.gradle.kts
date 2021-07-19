plugins {
    java
}

group = "by.issoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}