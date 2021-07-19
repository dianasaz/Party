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
    implementation("org.mapstruct:mapstruct:1.4.2.Final")
    implementation(project(":dto"))
    implementation(project(":jpa"))
    implementation(project(":common"))

    compileOnly("org.projectlombok:lombok:1.18.16")

    annotationProcessor ("org.projectlombok:lombok:1.18.16")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.4.2.Final")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}