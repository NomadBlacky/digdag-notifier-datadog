// give the user a nice default project!
ThisBuild / organization := "dev.nomadblacky"
ThisBuild / scalaVersion := "2.12.8"

lazy val root = (project in file("."))
  .enablePlugins(GraalVMNativeImagePlugin)
  .settings(
    name := "digdag-notifier-datadog",
    version := "0.0.1",
    graalVMNativeImageOptions ++= Seq(
      "--initialize-at-build-time",
      "--no-fallback",
      "--no-server",
      "--allow-incomplete-classpath"
    ),
    libraryDependencies ++= Seq(
      // CLI option parser
      "com.github.scopt" %% "scopt" % "3.7.1",
      // JSON parser
      "com.lihaoyi" %% "ujson" % "1.1.0",
      // HTTP client
      "com.softwaremill.sttp.client" %% "core" % "2.2.1",
      // Logging
      "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      // Test
      "org.scalatest" %% "scalatest" % "3.0.8" % Test
    )
  )
