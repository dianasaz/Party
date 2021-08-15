plugins {
    java
}

group = "by.issoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":dto"))
    implementation(project(":common"))

    compileOnly("org.projectlombok:lombok:1.18.16")

    annotationProcessor ("org.projectlombok:lombok:1.18.16")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}