package org.gradle.sample;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension;
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet;

public class KotlinConventionPlugin implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("org.jetbrains.kotlin.jvm");

        target.getRepositories().jcenter();

        KotlinJvmProjectExtension extension = target.getExtensions().getByType(KotlinJvmProjectExtension.class);
        KotlinSourceSet mainSourceSet = extension.getSourceSets().getByName("main");
        mainSourceSet.getKotlin().srcDir("kotlin");

        target.getDependencies().add("implementation", "org.jetbrains.kotlin:kotlin-stdlib-jdk8");
        target.getDependencies().add("testImplementation", "org.jetbrains.kotlin:kotlin-test");
        target.getDependencies().add("testImplementation", "org.jetbrains.kotlin:kotlin-test-junit");
    }
}
