description = "API Module"

dependencies {
    implementation(Dependencies.spring_boot_starter_web)
    implementation(Dependencies.spring_boot_starter_validation)
    implementation(Dependencies.spring_boot_starter_data_redis)

    testImplementation(Dependencies.spring_boot_starter_test)
    testImplementation(Dependencies.testcontainers)
    testImplementation(platform(Dependencies.junit_bom))
    testImplementation(Dependencies.junit_jupiter)
}
