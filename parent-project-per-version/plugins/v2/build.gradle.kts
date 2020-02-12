plugins {
    id("java-gradle-plugin")
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
}

gradlePlugin {
    plugins {
        register("kotlin") {
            id = "org.gradle.sample.kotlin-convention-v2"
            implementationClass = "org.gradle.sample.KotlinConventionPlugin"
        }
    }
}
