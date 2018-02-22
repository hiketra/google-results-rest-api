name := "google-results-rest-akka"

version := "1.0"

scalaVersion := "2.12.4"

scalaSource in Compile := baseDirectory.value / "src"
resourceDirectory in Compile := baseDirectory.value / "conf"
scalaSource in Test := baseDirectory.value / "test"
scalaSource in IntegrationTest := baseDirectory.value / "it"


val akkVersion = "2.5.9"
val akkaHttpVersion = "10.0.11"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.github.tomakehurst" % "wiremock" % "2.15.0" % IntegrationTest,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
    "org.scalatest" %% "scalatest" % "3.0.5" % "test, it",
    "org.jsoup" % "jsoup" % "1.8.3",
    "com.google.inject" % "guice" % "4.1.0")
}

lazy val root = (project in file(".")).configs(IntegrationTest).settings(Defaults.itSettings: _*)
