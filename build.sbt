import Dependencies._

lazy val commonSettings = Seq(
  organization := "inseo",
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  javaOptions ++= Seq("-Xms512M", "-Xmx2048M")
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)

lazy val client = (project in file("client"))
  .settings(commonSettings: _*)
  .settings(
    name := "finagle-client",
    libraryDependencies ++= clientDeps
  )

lazy val server = (project in file("server"))
  .settings(commonSettings: _*)
  .settings(
    name := "finagle-server",
    libraryDependencies ++= serverDeps
  )
