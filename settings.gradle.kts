pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Weather"
include(":app")
include(":features")
include(":features:sign-in")
include(":core")
include(":domain")
include(":data")
include(":features:sign-up")
include(":features:forgot-password")
