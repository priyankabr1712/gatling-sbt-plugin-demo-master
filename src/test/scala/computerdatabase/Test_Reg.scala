package computerdatabase


import scala.concurrent.duration._
  import io.gatling.core.Predef._
  import io.gatling.http.Predef._

import scala.util.Random

  class Test_Reg extends Simulation {

    val httpProtocol = http
      .baseUrl("https://ssl.google-analytics.com")
      .inferHtmlResources()
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")


    val headers_44 = Map(
      "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
      "Pragma" -> "no-cache",
      "Upgrade-Insecure-Requests" -> "1")


    val uri1 = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"
    val uri2 = "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com"
    val uri3 = "https://fonts.gstatic.com/s/opensans/v17"
    val uri5 = "https://_ui/responsive/theme-fsx/images/Loader.gif"
    val uri6 = "https://fonts.googleapis.com/css"

   // val feeder = Iterator.continually(Map("email" -> (Random.alphanumeric.take(10).mkString + "@foo.com")))

   val feeder = csv("NewUser.csv")
    val scn1 = scenario("RecordedSimulation")

      .exec(flushHttpCache)
      .exec(flushSessionCookies)
      .exec(flushCookieJar)

      .feed(feeder)
      .exec(http("HP")
        .get(uri2 + "/en_US/")
        .headers(headers_44))
      .pause(20)


      .exec(http("RP")
        .get(uri2 + "/en_US/register")
        .headers(headers_44)
        .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
          .saveAs("requestVerificationToken")))
      .pause(20)

      .exec(http("Submit Form")
        .post(uri2 + "/en_US/register/newcustomer")
        .headers(headers_44)
        .formParam("titleCode", "none")
        .formParam("termsCheck", "true")
        .formParam("firstName", "FSX5")
        .formParam("lastName", "pragiti")
        .formParam("phoneNumber", "(201) 782-9830")
        .formParam("phoneFull", "+12017829830")
        .formParam("companyName", "xyz")
        .formParam("industry", "Full_Service_Casual")
        .formParam("email", "${email}")
        .formParam("pwd", "12345678")
        .formParam("checkPwd", "12345678")
        .formParam("CSRFToken", "${requestVerificationToken}"))

    val scn2 = scenario("repeat")
      .exec(flushHttpCache)
      .exec(flushSessionCookies)
      .exec(flushCookieJar)

      .feed(feeder)

      .repeat(5)
        {
      exec(http("HP")
        .get(uri2 + "/en_US/")
        .headers(headers_44))
      .pause(20)


      .exec(http("RP")
        .get(uri2 + "/en_US/register")
        .headers(headers_44)
        .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
          .saveAs("requestVerificationToken")))
      .pause(20)

      .exec(http("Submit Form")
        .post(uri2 + "/en_US/register/newcustomer")
        .headers(headers_44)
        .formParam("titleCode", "none")
        .formParam("termsCheck", "true")
        .formParam("firstName", "FSX5R")
        .formParam("lastName", "pragiti")
        .formParam("phoneNumber", "(201) 782-9830")
        .formParam("phoneFull", "+12017829830")
        .formParam("companyName", "xyz")
        .formParam("industry", "Full_Service_Casual")
        .formParam("email", "${email}")
        .formParam("pwd", "12345678")
        .formParam("checkPwd", "12345678")
        .formParam("CSRFToken", "${requestVerificationToken}"))
  }
   // setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
    //setUp(scn.inject(atOnceUsers(5), (rampUsers(45) during (10 minutes)))).protocols(httpProtocol)
  //setUp(scn.inject(rampUsers(4) during (2 seconds)).protocols(httpProtocol),
    //setUp(scn.inject(constantConcurrentUsers(3) during (5 seconds))).protocols(httpProtocol)

   // setUp(scn.inject(incrementConcurrentUsers(10)  (3 seconds))
  // setUp(scn.inject(constantUsersPerSec(10) during(10 seconds)))
     // .protocols(httpProtocol)
   //setUp(scn.inject(rampUsers(100) during (50 minutes))).protocols(httpProtocol)
    //setUp(scn.inject(rampUsers(100) during (10 minutes)))
    //  .protocols(httpProtocol)
    setUp(scn1.inject(rampUsers(50) during (50 seconds)))
    //, atOnceUsers(25)))
    .protocols(httpProtocol)
  }

