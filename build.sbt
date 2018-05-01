name := """AthleteManage"""
organization := "ca.ycdsb"

version := "0.0.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean, JavaAppPackaging)


scalaVersion := "2.12.4"

libraryDependencies += guice

// H2 in-memory setup
//libraryDependencies += jdbc
//libraryDependencies += evolutions
libraryDependencies += "com.h2database" % "h2" % "1.4.192"

// Local PostgreSQL database setup
// libraryDependencies += "org.postgresql" % "postgresql" % "42.2.2"

herokuAppName in Compile := "str-athlete-manage"

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))