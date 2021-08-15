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
    implementation(project(":dto"))
    implementation(project(":serviceApi"))
    implementation(project(":common"))
    implementation(project(":restApi"))
    implementation(project(":restMapper"))
    implementation(project(":restModel"))

    compileOnly("org.projectlombok:lombok:1.18.16")

    annotationProcessor ("org.projectlombok:lombok:1.18.16")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}