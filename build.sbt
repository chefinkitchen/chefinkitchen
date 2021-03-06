import play.PlayJava

name := "chef-In-Kitchen"

scalaVersion := "2.11.2"

version := "1.0-SNAPSHOT"

val appDependencies = Seq(
  "be.objectify"  %% "deadbolt-java"     % "2.3.2",
  // Comment the next line for local development of the Play Authentication core:
  "org.elasticsearch" % "elasticsearch" % "1.4.2",
  "com.feth"      %% "play-authenticate" % "0.6.8",
  "postgresql"    %  "postgresql"        % "9.1-901-1.jdbc4",
  "commons-io" % "commons-io" % "2.4",
  javaCore,
  cache,
  javaWs,
  javaJdbc,
  javaEbean,
  "org.webjars" %% "webjars-play" % "2.3.0",
  "org.webjars" % "angularjs" % "1.1.5-1",
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.elasticsearch" % "elasticsearch" % "1.4.2",
  "io.searchbox" % "jest" % "0.1.5",
  "org.apache.commons" % "commons-io" % "1.3.2",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13"
)

//  Uncomment the next line for local development of the Play Authenticate core:
//lazy val playAuthenticate = project.in(file("modules/play-authenticate")).enablePlugins(PlayJava)

lazy val root = project.in(file("."))
  .enablePlugins(PlayJava)
  .settings(
    libraryDependencies ++= appDependencies
  )
  /* Uncomment the next lines for local development of the Play Authenticate core: */
  //.dependsOn(playAuthenticate)
  //.aggregate(playAuthenticate)
