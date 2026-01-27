plugins {
    kotlin("jvm") version "2.3.0"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.14.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.14.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
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
}