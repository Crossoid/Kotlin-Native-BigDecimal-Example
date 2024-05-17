# How to use BigDecimal on iOS (Kotlin Multiplatform)

Let's assume you want to use java.math.BigDecimal in a Kotlin Multiplatfrom project that targets Android and iOS.
That means you want to do something like what is visible in the [Use BigDecimal in commonMain](https://github.com/Crossoid/Kotlin-Native-BigDecimal-Example/commit/c7958fbdc61cf778340326dda11dfaa72e029b80) commit:

```
import java.math.BigDecimal

[...]

val first = BigDecimal("5")
val second = BigDecimal("8")
val result = "I can count with BigDecimal: $first * $second = ${first*second}"
```

This doesn't compile on iOS by default though, Kotlin does not have BigDecimal. But with
[Kotlin/Native BigDecimal](https://github.com/Crossoid/Kotlin-Native-BigDecimal), you can just add the dependency to your project,
and you get BigDecimal on iOS too.

Everything necessary is visible in the [Add the Kotlin-Native-BigDecimal dependency so that BigDecimal works on iOS too](https://github.com/Crossoid/Kotlin-Native-BigDecimal-Example/commit/3f9bdc42fb382ed90169bde84498c108442ac6a3) commit:

> [!NOTE]
> To be able to download from GitHub Packages, you need to set up a security token with `read:packages` scope. For details, please see [About scopes and permissions for package registries](https://docs.github.com/en/packages/learn-github-packages/about-permissions-for-github-packages#about-scopes-and-permissions-for-package-registries).

```
maven {
    setUrl("https://maven.pkg.github.com/crossoid/Kotlin-Native-BigDecimal")
    credentials {
        username = [...see the commit for details...]
        password = [...see the commit for details...]
    }
}

[...]

kotlin {
    [...]
    sourceSets {
        [...]
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
```

If you are interested in details, please see the [README](https://github.com/Crossoid/Kotlin-Native-BigDecimal/blob/master/README.md)

Enjoy!
