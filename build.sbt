organization := "com.gurghet"
name := "quaresima"
scalaVersion := "2.12.4"

val Http4sVersion = "0.17.5"
val LogbackVersion = "1.2.3"

libraryDependencies ++= Seq(
 "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
 "org.http4s"     %% "http4s-circe"        % Http4sVersion,
 "org.http4s"     %% "http4s-dsl"          % Http4sVersion,
 "ch.qos.logback" %  "logback-classic"     % LogbackVersion
)

resolvers += Resolver.bintrayIvyRepo("sbt", "sbt-plugin-releases")