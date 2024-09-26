name := "tic-tac-toe"

version := "0.1"

scalaVersion := "2.13.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.scalatestplus" %% "mockito-5-12" % "3.2.19.0" % Test,
  "org.mockito" % "mockito-core" % "5.13.0" % Test
)


// Assembly plugin settings
import sbtassembly.AssemblyPlugin.autoImport._
assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case "application.conf" => MergeStrategy.concat
  case _ => MergeStrategy.first
}

// Specify the main class for the fat JAR
mainClass in assembly := Some("Main")