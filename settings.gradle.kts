pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven(url = "https://plugins.gradle.org/m2/")
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Coding Challenge"
include(
    ":app",
    ":core-ui",
    ":core-sdk",
    ":common",

    ":datasources",
    ":datasources:pixabay",
    ":datasources:api",

    ":feature-images"
)
