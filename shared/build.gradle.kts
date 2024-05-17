plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        val iosArm64Main by getting {
            dependencies {
                implementation("com.crossoid:kotlin-native-bigdecimal:1.0")
            }
        }
        val iosSimulatorArm64Main by getting {
            dependencies {
                implementation("com.crossoid:kotlin-native-bigdecimal:1.0")
            }
        }
    }
}

android {
    namespace = "com.crossoid.bigdecimal_example"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
