val javaVersion = "17"
val gradleVersion = "7.6.4"
val jacocoVersion = "0.8.12"

plugins {
    kotlin("jvm") version "1.9.23"
    jacoco
}

group = "com.github.dkoval.leetcode"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.16.1")
}

jacoco {
    toolVersion = jacocoVersion
}

tasks {
    compileJava {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    compileTestJava {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersion
    }

    test {
        useJUnitPlatform()
        testLogging { events("passed", "skipped", "failed") }
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        //dependsOn(test)
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }

    wrapper {
        gradleVersion = gradleVersion
    }
}