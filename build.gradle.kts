plugins {
    kotlin("jvm") version "2.0.20"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.3")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

kotlin {
    // updates the toolchain for Java compile tasks as well
    jvmToolchain(21)
}

jacoco {
    toolVersion = "0.8.12"
}

tasks {
    test {
        useJUnitPlatform()
        testLogging { events("passed", "skipped", "failed") }
        finalizedBy(jacocoTestReport)
        jvmArgs("-Xss4m")
    }

    jacocoTestReport {
        dependsOn(test)
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }

    wrapper {
        gradleVersion = "8.10"
    }
}