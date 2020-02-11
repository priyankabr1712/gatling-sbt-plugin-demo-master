package computerdatabase

  import io.gatling.core.Predef._
  import io.gatling.http.Predef._
import scala.concurrent.duration._

  import SLP._
  import QuickView._
  import Login._


class SLP_Cart extends Simulation {

    val httpProtocol = http
      .baseUrl("https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com")
      .inferHtmlResources()
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")


    val feeder = csv("pro-fsxlist.csv").circular
    val urlfeeder = csv("url.csv").circular
    val scn = scenario("SLPToCart")
      .exec(flushHttpCache)
      .exec(flushSessionCookies)
      .exec(flushCookieJar)

      .feed(feeder)
      .feed(urlfeeder)
              .exec(Login hp, Login lp, SLP slp, QuickView qv, QuickView addtocart, CartPage cart)

    //setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
 // setUp(scn.inject(atOnceUsers(5), (rampUsers(45) during (10 minutes)))).protocols(httpProtocol)
 // setUp(scn.inject(constantUsersPerSec(1) during(50 seconds)))
   // .protocols(httpProtocol)

  setUp(scn.inject(constantUsersPerSec(10) during(10 seconds)))
    .protocols(httpProtocol)
}
