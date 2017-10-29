organization := "com.gurghet"
name := "quaresima"
scalaVersion := "2.12.4"

val Http4sVersion = "0.18.0-M2"
val LogbackVersion = "1.2.3"
val DoobieVersion = "0.5.0-M8"

libraryDependencies ++= Seq(
  "org.http4s"            %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s"            %% "http4s-circe"        % Http4sVersion,
  "org.http4s"            %% "http4s-dsl"          % Http4sVersion,
  "ch.qos.logback"        %  "logback-classic"     % LogbackVersion,
  "org.tpolecat"          %% "doobie-core"         % DoobieVersion,
  "org.tpolecat"          %% "doobie-h2"           % DoobieVersion,
  "io.circe"              %% "circe-generic"       % "0.9.0-M1",
  "co.fs2"                %% "fs2-cats"            % "0.4.0",
  "com.github.pureconfig" %% "pureconfig"          % "0.8.0"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

resolvers += Resolver.bintrayIvyRepo("sbt", "sbt-plugin-releases")

cancelable in Global := true

flywayUrl in Test := "jdbc:h2:tcp://localhost/./test"
flywayUrl := "jdbc:h2:tcp://localhost/./test"