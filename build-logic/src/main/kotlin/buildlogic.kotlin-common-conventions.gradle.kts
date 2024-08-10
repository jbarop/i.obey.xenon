internal val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
  id("org.jetbrains.kotlin.jvm")
}

repositories {
  mavenCentral()
}

dependencies {
  constraints {
    implementation("org.apache.commons:commons-text:1.11.0")
  }
}

testing {
  suites {
    val test by getting(JvmTestSuite::class) {
      useJUnitJupiter(versionCatalog.findVersion("junit").get().requiredVersion)
    }
    dependencies {
      implementation(versionCatalog.findLibrary("hamcrest").get())
      implementation(versionCatalog.findLibrary("mockito-kotlin").get())
    }
  }
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}
