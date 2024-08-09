plugins {
  id("buildlogic.kotlin-application-conventions")
}

dependencies {
  implementation(project(":domain"))
}

application {
  mainClass = "iobeyxenon.cli.AppKt"
}
