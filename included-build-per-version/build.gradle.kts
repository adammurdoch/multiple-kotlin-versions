// A task that depends on a task from each included build
tasks.register("run") {
    dependsOn(gradle.includedBuild("v1").task(":a:run"))
    dependsOn(gradle.includedBuild("v2").task(":c:run"))
}
