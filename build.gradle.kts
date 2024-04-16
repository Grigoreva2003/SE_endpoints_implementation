plugins {
    id("org.openapi.generator") version "7.2.0"
    java
}

repositories {
    mavenCentral()
}

//tasks.jar {
//    manifest {
//        attributes["Main-Class"] = "com.harbour.space.grigoreva.homework6.QuestApplication"
//    }
//}
//
//sourceSets {
//    main {
//        java {
//            srcDirs("homework6/src/main/java")
//        }
//    }
//}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

group = "org.example"
version = "1.0-SNAPSHOT"


sourceSets {
    test {
        java.srcDir("$projectDir/src/test/java")
    }
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