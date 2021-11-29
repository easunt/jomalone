import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id ("org.jetbrains.kotlin.plugin.jpa") version "1.5.10" //generate no arg constructor for @Entity
    id ("org.jetbrains.kotlin.plugin.allopen") version "1.5.10" //remove final keyword for @Entity
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

group = "com.perfume"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.core:jackson-core:2.10.3")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // jdk 확인하

    implementation ("com.jayway.jsonpath:json-path:2.4.0")
    implementation("com.spotify:docker-client:8.16.0")

    implementation("net.logstash.logback:logstash-logback-encoder:6.6")

    implementation("org.glassfish.jersey.inject:jersey-hk2:2.30")
    implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")

    runtimeOnly("mysql:mysql-connector-java:8.0.21")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
