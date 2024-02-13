plugins {
    id("org.openapi.generator") version "7.2.0"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/specs/openapi.yaml")
    outputDir.set("$projectDir/generated")
    generateModelDocumentation.set(false)
    generateApiTests.set(false)
    generateModelTests.set(false)
    generateApiDocumentation.set(false)
}