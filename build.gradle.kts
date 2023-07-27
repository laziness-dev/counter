import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(Plugins.spring_boot) version Plugins.Versions.spring_boot
    id(Plugins.spring_dependency_management) version Plugins.Versions.spring_dependency_management apply false

    id(Plugins.ktlint) version Plugins.Versions.ktlint
    kotlin(Plugins.jvm) version Plugins.Versions.kotlin
    kotlin(Plugins.plugin_spring) version Plugins.Versions.kotlin
    kotlin(Plugins.plugin_jpa) version Plugins.Versions.kotlin
}

group = "org.github.laziness"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin(Plugins.java_library)
        plugin(Plugins.kotlin)
        plugin(Plugins.kotlin_jpa)
        plugin(Plugins.kotlin_spring)
        plugin(Plugins.spring_boot)
        plugin(Plugins.spring_dependency_management)
        plugin(Plugins.java_test_fixtures)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }
}
