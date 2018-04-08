import sbt._

object Dependencies {
  lazy val finagleVersion = "6.38.0"

  // Finagle
  val finagleHTTP = "com.twitter" %% "finagle-http" % finagleVersion

  // Projects
  val clientDeps = Seq(finagleHTTP)
  val serverDeps = Seq(finagleHTTP)
}
