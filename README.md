Some mock-ups of patterns to define a Gradle build containing some projects built using Kotlin 1.3.60 and some other projects
built using Kotlin 1.3.50.

### Parent project per Kotlin version

Directory `parent-project-per-version` contains a multi-project build, where the Kotlin 1.3.60 projects are grouped under
a parent project called `v1`, and the Kotlin 1.3.50 projects are grouped under a project called `v2`.

This build also contains a couple of convention plugins, one for each of the Kotlin versions. The implementation of these
plugins lives under the `plugins` subdirectory, which included as a child build.

There is some not-so-obvious glue to connect these pieces together:

In `settings.gradle.kts`, the plugins build is included, to make these
plugins available to apply in any of the projects. However, the classes for these plugins are only visible to those
projects that apply them.

In `v1/build.gradle.kts` and `v2/build.gradle.kts`, one of the plugins is made visible to the project and its subprojects, but not applied. Any of the subprojects can then apply the plugin by id. While not strictly necessary, this is done for performance 
reasons, so that the classes for the plugin and its dependencies, such as the Kotlin plugin, are loaded once (by the parent
project) and then inherited by the subprojects.

To try this build out, run `./gradlew run` (or `./gradlew :v1:a:run`) from the root directory of this build.

### Included build per Kotlin version

Directory `included-build-per-version` contains a composite build, where the Kotlin 1.3.60 projects are grouped under
an included build called `v1`, and the Kotlin 1.3.50 projects are grouped under an included build called `v2`.

The convention plugin for each version lives in a `buildSrc` directory in the corresponding included build.

In this build, the pieces are connected together in `settings.gradle.kts`, which includes the `v1` and `v2` builds.
The classes and plugins defined in an included build's `buildSrc` are visible only to the projects of that build.

To try this build out, run `./gradlew run` (or `./gradlew -p v1 :a:run`) from the root directory of this build.
