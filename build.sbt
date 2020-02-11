enablePlugins(GatlingPlugin, FrontLinePlugin)

val gatlingVersion = "3.2.0"
val frontlineVersion = "1.7.0"

scalaVersion := "2.12.8"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-test-framework" % gatlingVersion
//libraryDependencies += "io.gatling.frontline" % "frontline-probe" %frontlineVersion


libraryDependencies += "io.gatling" % "gatling-commons" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-netty-util" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-core" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-graphite" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-compiler" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-recorder" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-http" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-charts" % gatlingVersion
libraryDependencies += "io.gatling" % "gatling-app" % gatlingVersion
