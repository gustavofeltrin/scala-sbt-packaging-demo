val scala3Version = "3.8.2"

lazy val root = project
  .in(file("."))
  .settings(
    licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")),
    description := "A demo project for packaging Scala 3 apps with sbt-assembly",
    
    name := "scala-sbt-packaging-demo",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.2.4" % Test,

    // Point to the @main method name, since is 'def main()', the class generated is 'main'
    Compile / mainClass := Some("main"),
    assembly / mainClass := Some("main"),

    // Custom name for your Uber JAR
    assembly / assemblyJarName := s"${name.value}-assembly-${version.value}.jar",

    // Merge Strategy, this prevents "deduplicate" errors when merging Scala 3 library files
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )