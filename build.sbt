name := """Primate_Play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "commons-io" % "commons-io" % "2.5"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
