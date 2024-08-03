plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val mainClassName = "org.example.Main"

tasks.jar {
    manifest {
        attributes["Main-Class"] = mainClassName
    }

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

tasks.register<Jar>("customFatJar") {
    manifest {
        attributes["Main-Class"] = mainClassName
    }

    archiveBaseName.set("all-in-one-jar")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    from(tasks.jar.get().outputs)
}

dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")

}

//tasks.test {
//    useJUnitPlatform()
//}
