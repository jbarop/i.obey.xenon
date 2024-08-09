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
      useJUnitJupiter("5.10.2")
    }
  }
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}
