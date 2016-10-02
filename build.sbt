name := "renesca-magic-hack"

// don't forget to change the version in README.md
version := "1.0.0-SNAPSHOT"
val scalaV = "2.11.8"
val paradiseVersion = "2.1.0"
scalaVersion := scalaV

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases" // specs2

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaV
)

addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full)

scalacOptions ++= scalacOpts

// scalaxy (faster collection operations)
scalacOptions += "-Xplugin-require:scalaxy-streams"
autoCompilerPlugins := true
addCompilerPlugin("com.nativelibs4java" %% "scalaxy-streams" % "0.3.4")

// publishing
organization := "com.github.renesca"

val scalacOpts = (
  "-encoding" :: "UTF-8" ::
  "-unchecked" ::
  "-deprecation" ::
  "-explaintypes" ::
  "-feature" ::
  "-Yinline" :: "-Yinline-warnings" ::
  "-language:_" ::
  // "-Xdisable-assertions" :: "-optimize" ::
  Nil
)

val scalacMacroOpts = (
  "-Ymacro-debug-lite" ::
  "-Yshow-trees-stringified" ::
  Nil
)
