plugins {
    java
}

group = "by.issoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.8.RELEASE")
    implementation(project(":common"))
    implementation(project(":restModel"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}