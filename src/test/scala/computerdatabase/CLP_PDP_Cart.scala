package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import Headers._
import Login._
import CLP._
import PDP_AddCart._
import CartPage._



class CLP_PDP_Cart extends Simulation {

  val httpProtocol = http
    .baseUrl("https://fonts.googleapis.com")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")


  val urlfeeder = csv("url.csv").circular
  val userfeeder = csv("users.csv").circular
  val upsfeeder = csv("UPSshipping.csv").circular
  val echofeeder = csv("EchoShipping.csv").circular
  val miraklfeeder = csv("MiraklShipping.csv").circular
  val freeshippingfeeder = csv("FreeShipping.csv").circular
  val profsxlistfeeder = csv("pro-fsxlist.csv").circular

  val credentialsfeeder = csv("Credentials.csv").circular

  val scn1 = scenario("S1")

    .exec(flushHttpCache)
    .exec(flushSessionCookies)
    .exec(flushCookieJar)


    .feed(urlfeeder)
    .feed(userfeeder)
    .feed(upsfeeder)
    .feed(echofeeder)
    .feed(miraklfeeder)
    .feed(freeshippingfeeder)
    .feed(credentialsfeeder)
    .feed(profsxlistfeeder)

    .exec(Login hp, CLP barclp)
  // Login lp)

  val scn2 = scenario("S2")

    .exec(flushHttpCache)
    .exec(flushSessionCookies)
    .exec(flushCookieJar)


    .feed(urlfeeder)
    .feed(userfeeder)
    .feed(upsfeeder)
    .feed(echofeeder)
    .feed(miraklfeeder)
    .feed(freeshippingfeeder)
    .feed(credentialsfeeder)
    .feed(profsxlistfeeder)

    .exec(Login hp,
      PDP_AddCart pdp)


  setUp(scn1.inject(rampUsers(4) during (15 seconds)),
    scn2.inject(rampUsers(users = 4) during (15 seconds))).protocols(httpProtocol)

}

















//   SLP_PDP_CART p4,
//SLP_PDP_CART p2, SLP_PDP_CART p3, SLP_PDP_CART p4,
//   Checkout cart_checkout)

/*val scn2 = scenario("S2")
  .exec(flushHttpCache)
  .exec(flushSessionCookies)
  .exec(flushCookieJar)

  .feed(feeder)
  .feed(urlfeeder)
  .feed(lightfeeder)

  .repeat(2)
  {
    exec(Login hp,
    Login lp)
  }*/
 //setUp(scn1.inject(rampUsers(100) during (120 seconds))).protocols(httpProtocol)
        //scn2.inject((atOnceUsers(50))).protocols(httpProtocol))
    //,(rampUsers(100) during (10 seconds))))
 // .protocols(httpProtocol)
 //setUp(scn1.inject(atOnceUsers(1))).protocols(httpProtocol)
  //setUp(scn.inject(constantUsersPerSec(1) during(10 seconds)))
   // .protocols(httpProtocol)
//}