import java.util.Properties

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

        // Load properties from github.properties
        val githubProperties = Properties()
        file("github.properties").takeIf { it.exists() }?.inputStream()?.use { githubProperties.load(it) }

        maven {
            url = uri("https://maven.pkg.github.com/neolink557/ArchitectureApp_DesignSystem")
            credentials {
                username = githubProperties.getProperty("gpr.user") ?: System.getenv("GPR_USER")
                password = githubProperties.getProperty("gpr.token") ?: System.getenv("GPR_TOKEN")
            }
        }
    }
}

rootProject.name = "ArechitectureApp"
include(":app")
 