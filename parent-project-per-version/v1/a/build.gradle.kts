plugins {
    id("org.gradle.sample.kotlin-convention-v1")
    id("application")
}

application {
    mainClassName = "a.MainKt"
}

dependencies {
    implementation(project(":v1:b"))
}
