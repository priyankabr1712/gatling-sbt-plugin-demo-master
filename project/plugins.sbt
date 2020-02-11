// only if you intend to use the gatling-sbt plugin for running Gatling locally
addSbtPlugin("io.gatling" % "gatling-sbt" % "3.0.0")
// so sbt can build a package for FrontLine
addSbtPlugin("io.gatling.frontline" % "sbt-frontline" % "1.0.1")

addSbtPlugin("com.eed3si9n"%"sbt-assembly"%"0.14.6")
addSbtPlugin("io.gatling"%"gatling-sbt"%"2.2.2")