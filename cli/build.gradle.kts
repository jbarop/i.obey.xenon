plugins {
  id("buildlogic.kotlin-application-conventions")
}

dependencies {
  implementation(project(":domain"))
}

application {
  mainClass = "iobeyxenon.cli.AppKt"
}

tasks.named<JavaExec>("run") {
  standardInput = System.`in`
}
