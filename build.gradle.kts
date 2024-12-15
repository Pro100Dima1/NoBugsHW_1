plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:4.5.1")
    testImplementation("com.google.code.gson:gson:2.8.9")
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

}

tasks.test {
    useJUnitPlatform()
}