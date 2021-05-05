plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.1.8.RELEASE")
    implementation("org.apache.commons:commons-dbcp2:2.1.1")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.1.8.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.1.8.RELEASE")
    runtimeOnly("mysql:mysql-connector-java:8.0.17")
    compileOnly("org.projectlombok:lombok:1.18.16")
    annotationProcessor ("org.projectlombok:lombok:1.18.16")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.1.8.RELEASE")
    testImplementation("com.h2database:h2:1.4.200")
}

group = "by.iba"
version = "1.0-SNAPSHOT"
description = "party"
java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
