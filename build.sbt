name := "renesca-magic"

version := "0.1.7"

val scalaV = "2.11.6"

val paradiseVersion = "2.1.0-M5"

lazy val renescamagic = (project in file(".")).settings(
  scalaVersion := scalaV,
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaV,
  addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full),
  scalacOptions ++= scalacOpts
)

lazy val test = (project in file("test")).settings(
  scalaVersion := scalaV,
  resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases", // specs2
  libraryDependencies ++= Seq(
    "org.specs2" %% "specs2-core" % "3.6" % "test",
    "org.specs2" %% "specs2-mock" % "3.6" % "test",
    "org.scala-lang" % "scala-compiler" % scalaV % "test",
    "com.github.renesca" %% "renesca" % "0.2.2"
  ),
  addCompilerPlugin("org.scalamacros" % "paradise" % paradiseVersion cross CrossVersion.full),
  scalacOptions in Test ++= Seq("-Yrangepos") // specs2
).dependsOn(renescamagic)


// publishing
pgpSecretRing := file("local.secring.gpg")

pgpPublicRing := file("local.pubring.gpg")

organization := "com.github.renesca"

pomExtra := {
  <url>https://github.com/renesca/renesca-magic</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      </license>
    </licenses>
    <scm>
      <url>https://github.com/renesca/renesca-magic</url>
      <connection>scm:git:git@github.com:renesca/renesca-magic.git</connection>
    </scm>
    <developers>
      <developer>
        <id>fdietze</id>
        <name>Felix Dietze</name>
        <url>https://github.com/fdietze</url>
      </developer>
      <developer>
        <id>jkaroff</id>
        <name>Johannes Karoff</name>
        <url>https://github.com/cornerman</url>
      </developer>
    </developers>
}


val scalacOpts = Seq(
  "-encoding", "UTF-8",
  "-unchecked",
  "-deprecation",
  "-explaintypes",
  "-feature",
  "-Yinline", "-Yinline-warnings",
  "-language:_"
  //,"-Xdisable-assertions", "-optimize"
)

val scalacMacroOpts = Seq(
  "-Ymacro-debug-lite",
  "-Yshow-trees-stringified"
)

