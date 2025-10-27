plugins {
    application
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.avro)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.avro)
    implementation(libs.guava)
    implementation(libs.spring.framework)

    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

avro {
    fieldVisibility = "PRIVATE"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "com.detector.Application"
}

tasks.named<Test>("test") {
// Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

