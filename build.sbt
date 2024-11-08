name := "forestry"

organization := "roikonen.fi"
organizationHomepage := Some(url("https://roikonen.fi"))
version := "1.0.0"

scalaVersion := "3.5.2"

val log4s               = "org.log4s"                     %% "log4s"             % "1.10.0"
val logback             = "ch.qos.logback"                 % "logback-classic"   % "1.5.6"
val scalatest           = "org.scalatest"                 %% "scalatest"         % "3.2.19" % Test

libraryDependencies ++= Seq(log4s, logback, scalatest)
