plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
    kotlin("plugin.jpa") version "1.9.25"
    kotlin("kapt") version "2.0.20"
}

group = "com.dino"
version = "0.0.1-SNAPSHOT"
val queryDslVersion = "5.0.0" // QueryDSL Version Setting

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // mysql
    implementation("mysql:mysql-connector-java:8.0.33")

    // spring data jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // querydsl
    implementation ("com.querydsl:querydsl-jpa:${queryDslVersion}:jakarta")
    annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:jakarta")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")

    // lombok
    implementation("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // swagger api docs
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    // h2 database
    testImplementation("com.h2database:h2")
    testImplementation("org.mockito:mockito-core:5.0.0")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
