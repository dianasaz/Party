plugins {
    java
}

group = "by.issoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.1.8.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.8.RELEASE")
    implementation(project(":dto"))
    implementation(project(":dao"))
    implementation(project(":entity"))
    implementation(project(":common"))
    implementation(project(":mapper"))
    implementation(project(":serviceApi"))

    compileOnly("org.projectlombok:lombok:1.18.16")

    annotationProcessor ("org.projectlombok:lombok:1.18.16")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}