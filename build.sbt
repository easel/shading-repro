scalaOrganization in ThisBuild := "org.typelevel" // prevent deriveDecoder failures
scalaVersion in ThisBuild := "2.11.8"
libraryDependencies in ThisBuild := Dependencies.Circe ++ Dependencies.Shapeless

lazy val root = project
  .in(file("."))
  .aggregate(works, fails)
  .disablePlugins(sbtassembly.AssemblyPlugin)

lazy val works = project
  .in(file("./works"))
  .settings(
    assemblyOption in assembly := (assemblyOption in assembly).value
      .copy(includeScala = false),
    assemblyShadeRules in assembly := Seq(
      ShadeRule
        .rename("shapeless.**" -> "shadeless.@1")
        .inAll // works
    )
  )

lazy val fails = project
  .in(file("./fails"))
  .settings(
    assemblyOption in assembly := (assemblyOption in assembly).value
      .copy(includeScala = false),
    assemblyShadeRules in assembly := Seq(
      ShadeRule
        .rename("shapeless.**" -> "shadeless.@1")
        .inLibrary(Dependencies.WithShapeless: _*) // doesn't work
        .inProject
    )
  )
