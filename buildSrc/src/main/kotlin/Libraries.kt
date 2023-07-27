object Plugins {
    const val spring_boot = "org.springframework.boot"
    const val spring_dependency_management = "io.spring.dependency-management"

    const val ktlint = "org.jlleitschuh.gradle.ktlint"

    const val jvm = "jvm"
    const val plugin_spring = "plugin.spring"
    const val plugin_jpa = "plugin.jpa"

    const val java_library = "java-library"
    const val kotlin = "kotlin"
    const val kotlin_jpa = "kotlin-jpa"
    const val kotlin_spring = "kotlin-spring"

    const val java_test_fixtures = "java-test-fixtures"

    object Versions {
        const val spring_boot = "3.0.4"
        const val spring_dependency_management = "1.1.0"

        const val kotlin = "1.8.10"
        const val ktlint = "10.3.0"
    }
}

object Dependencies {
    const val spring_boot_starter_web = "org.springframework.boot:spring-boot-starter-web"
    const val spring_boot_starter_validation = "org.springframework.boot:spring-boot-starter-validation"
    const val spring_boot_starter_data_redis = "org.springframework.boot:spring-boot-starter-data-redis"

    const val spring_boot_starter_test = "org.springframework.boot:spring-boot-starter-test"
    const val testcontainers = "org.testcontainers:testcontainers:${Versions.test_containers}"
    const val junit_bom = "org.junit:junit-bom:${Versions.junit_bom}"
    const val junit_jupiter = "org.junit.jupiter:junit-jupiter"

    object Versions {
        const val test_containers = "1.18.3"
        const val junit_bom = "5.9.1"
    }
}

object Modules {
    const val api = "api"
    const val counter_core = "counter-core"
    const val counter_get_api = "counter-get-api"
    const val counter_hit_api = "counter-hit-api"
    const val counter_hit_consumer = "counter-hit-consumer"
    const val counter_cdc = "counter-cdc"
}
