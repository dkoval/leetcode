plugins {
    kotlin("jvm") version "1.6.10"
    jacoco
}

group = "com.github.dkoval.leetcode"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.16.1")
}

tasks {
    compileJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    compileTestJava {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    test {
        useJUnitPlatform()
        testLogging { events("passed", "skipped", "failed") }
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        dependsOn(test)
    }

    wrapper {
        gradleVersion = "7.3.3"
    }
}