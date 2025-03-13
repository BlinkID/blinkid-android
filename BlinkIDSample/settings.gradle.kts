pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        // add Microblink maven repository to repositories list
        maven {
            url = uri("https://maven.microblink.com")
        }
    }
}

rootProject.name = "BlinkIDSample"
include(":sample-app")
include(":lib-common")
include(":microblink-ux")
include(":blinkid-ux")



