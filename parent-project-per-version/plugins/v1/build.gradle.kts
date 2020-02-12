plugins {
    id("java-gradle-plugin")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.60")
}

gradlePlugin {
    plugins {
        register("kotlin") {
            id = "org.gradle.sample.kotlin-convention-v1"
            implementationClass = "org.gradle.sample.KotlinConventionPlugin"
        }
    }
}
