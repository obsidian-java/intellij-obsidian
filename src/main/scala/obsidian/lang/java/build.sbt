name := "obsidian"
version := "0.1.0"

Global / sbtVersion := "1.9.7"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / resolvers += "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/"
ThisBuild / resolvers += "Maven Repository" at "https://mvnrepository.com/artifact/"
ThisBuild / resolvers += "clojars" at "https://clojars.org/repo"
ThisBuild / resolvers += "obsidian binary github repo" at "https://raw.githubusercontent.com/obsidian-java/binrepo/master/"

ThisBuild / scalacOptions ++= Seq("-source:future") // solve the withFilter is not a member error.

libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0",
      "org.scalactic" %% "scalactic" % "3.2.9",
      "org.scalatest" %% "scalatest" % "3.2.9" % "test",
      "org.scala-lang" %% "toolkit" % "0.1.7",
      "org.typelevel" %% "cats-core" % "2.10.0",
      "obsidian.lang.java" %% "scalangj" % "0.1.8"
    )

lazy val root = (project in file("."))
  .settings(
        name := "Obsidian",
        libraryDependencies ++= Seq(
              "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0",
              "org.scalactic" %% "scalactic" % "3.2.9",
              "org.scalatest" %% "scalatest" % "3.2.9" % "test",
              "org.scala-lang" %% "toolkit" % "0.1.7",
              "org.typelevel" %% "cats-core" % "2.10.0",
              "obsidian.lang.java" %% "scalangj" % "0.1.8"
        )
  )
