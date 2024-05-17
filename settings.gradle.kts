enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://maven.pkg.github.com/crossoid/Kotlin-Native-BigDecimal")
            credentials {
                //
                // The following reads the GitHub Packages credentials from local.properties, so that they
                // don't have to be spelled out here and potentially checked into version control system.
                //
                // Please add entries like the following to your local.properties:
                //
                //   github_user=<your github username>
                //   github_token=<generate a github token with read:packages permission>
                //
                // More info about the token here:
                //   https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries
                //
                val localProperties = File(rootDir, "local.properties").inputStream().use {
                    java.util.Properties().apply { load(it) }
                }
                val ghUsername: String
                val ghPassword: String
                try {
                    ghUsername = localProperties.getValue("github_user") as String
                    ghPassword = localProperties.getValue("github_token") as String
                } catch (_: NoSuchElementException) {
                    throw RuntimeException("ERROR: 'github_user' or 'github_token' not defined in local.properties, please consult https://github.com/Crossoid/Kotlin-Native-BigDecimal/blob/master/README.md")
                }

                username = ghUsername
                password = ghPassword
            }
        }
    }
}

rootProject.name = "Kotlin-Native-BigDecimal-Example"
include(":androidApp")
include(":shared")