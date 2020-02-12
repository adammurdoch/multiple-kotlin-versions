plugins {
    // Make the plugin available to subprojects, but do not apply it to this project
    id("org.gradle.sample.kotlin-convention-v1").apply(false)
}

// Each subproject applies the convention plugin in a plugins { } block, but could also use a subprojects { } block here
