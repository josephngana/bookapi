import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}

name := """bookapi"""
organization := "za.ac.cput"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala, DebianPlugin, JavaAppPackaging, SystemdPlugin)

scalaVersion := "2.12.6"

scalacOptions += "-Ypartial-unification"

val PhantomVersion =  "2.24.10"
val PlayFrameWorkVersion = "2.6.19"
val catsVersion = "1.3.1"

maintainer := "Boniface Kabaso <boniface@kabaso.com>"
packageSummary in Linux := "Book REST API"
packageDescription := "BOOK REST API "

dockerCommands := Seq(
  Cmd("FROM", "anapsix/alpine-java:jdk8"),
  Cmd("MAINTAINER", maintainer.value),
  Cmd("WORKDIR", "/opt/docker"),
  Cmd("ADD", "/opt /opt"),
  ExecCmd("RUN", "chown", "-R", "daemon:daemon", "."),
  Cmd("USER", "daemon"),
  Cmd("WORKDIR", "/opt/docker"),
  ExecCmd("ENTRYPOINT", "bin/bookapi"),
  Cmd("VOLUME", "/opt/docker"),
  Cmd("EXPOSE", "9000"),
  Cmd("EXPOSE", "9999"),
  Cmd("EXPOSE", "8888")
)

javaOptions in Universal ++= Seq(
  // JVM memory tuning
  "-J-Xms4g",
  "-J-Xmx4g",
  "-J-Xmn2g"
)

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "org.scalactic" % "scalactic_2.12" % "3.0.5"

libraryDependencies += "javax.mail" % "javax.mail-api" % "1.6.1"
libraryDependencies += "org.typelevel" % "cats-core_2.12" % catsVersion
libraryDependencies += "org.typelevel" %% "cats-effect" % "0.10.1"

libraryDependencies += "com.github.romix.akka" % "akka-kryo-serialization_2.12" % "0.5.2"
libraryDependencies += "com.esotericsoftware" % "kryo" % "4.0.1"
libraryDependencies += "com.github.t3hnar" % "scala-bcrypt_2.12" % "3.1"
libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "3.10.0"
libraryDependencies += "com.squareup.moshi" % "moshi" % "1.6.0"
libraryDependencies += "com.squareup.moshi" % "moshi-adapters" % "1.6.0"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.7"
libraryDependencies += "org.apache.commons" % "commons-email" % "1.5"
libraryDependencies += "commons-io" % "commons-io" % "2.6"

libraryDependencies += "com.roundeights" % "hasher_2.12" % "1.2.0"
libraryDependencies += "com.sendgrid" % "sendgrid-java" % "4.2.1"
libraryDependencies += "org.bitbucket.b_c" % "jose4j" % "0.6.4"
libraryDependencies += "com.rometools" % "rome" % "1.10.0"
libraryDependencies += "org.jsoup" % "jsoup" % "1.11.3"
libraryDependencies += "com.softwaremill.sttp" %% "core" % "1.2.1"

libraryDependencies += "com.typesafe.play" % "play-iteratees_2.12" % "2.6.1"
libraryDependencies += "com.typesafe.play" % "play-iteratees-reactive-streams_2.12" % "2.6.1"

libraryDependencies += "com.outworkers" % "phantom-dsl_2.12" % PhantomVersion
libraryDependencies += "com.outworkers" % "phantom-connectors_2.12" % PhantomVersion
libraryDependencies += "com.outworkers" % "phantom-streams_2.12" % PhantomVersion
libraryDependencies += "com.outworkers" % "phantom-jdk8_2.12" % PhantomVersion

libraryDependencies += "com.typesafe.play" % "play-json_2.12" % "2.6.9"
libraryDependencies += "com.typesafe.play" % "play-akka-http-server_2.12" % PlayFrameWorkVersion
libraryDependencies += "com.typesafe.play" % "play-guice_2.12" % PlayFrameWorkVersion
libraryDependencies += "com.typesafe.play" % "play-ws_2.12" % PlayFrameWorkVersion

resolvers ++= Seq(
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "softprops-maven" at "http://dl.bintray.com/content/softprops/maven",
  "Brando Repository" at "http://chrisdinn.github.io/releases/",
  "Sonatype repo" at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging" at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/",
  "Twitter Repository" at "http://maven.twttr.com",
  "Websudos releases" at "https://dl.bintray.com/websudos/oss-releases/",
  "Goose Updates " at "https://dl.bintray.com/raisercostin/maven/",
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("public")
)
