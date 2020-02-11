package computerdatabase


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._


class PlaceOrder extends Simulation {

  val httpProtocol = http
    .baseUrl("https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com")
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:68.0) Gecko/20100101 Firefox/68.0")

  val headers_0 = Map(
    "Accept" -> "text/css,*/*;q=0.1",
    "Pragma" -> "no-cache",
    "TE" -> "Trailers")

  val headers_2 = Map(
    "Accept" -> "image/webp,*/*",
    "Pragma" -> "no-cache")

  val headers_3 = Map(
    "Accept" -> "text/css,*/*;q=0.1",
    "Pragma" -> "no-cache")

  val headers_7 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_10 = Map("Pragma" -> "no-cache")

  val headers_20 = Map(
    "Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
    "Accept-Encoding" -> "identity",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache",
    "TE" -> "Trailers")

  val headers_113 = Map(
    "Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
    "Accept-Encoding" -> "identity",
    "Pragma" -> "no-cache")

  val headers_121 = Map(
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_126 = Map(
    "Accept" -> "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8",
    "Pragma" -> "no-cache")

  val headers_149 = Map(
    "Accept" -> "application/json, text/javascript, */*; q=0.01",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_583 = Map(
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_967 = Map(
    "Accept" -> "text/html, */*; q=0.01",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")



  val uri1 = "https://ak1s.abmr.net/is/www.paypalobjects.com"
  val uri3 = "https://apitest.authorize.net/xml/v1/request.api"
  val uri4 = "https://www.googletagmanager.com/gtm.js"
  val uri5 = "https://fonts.gstatic.com/s/opensans/v17"
  val uri6 = "https://jstest.authorize.net"
  val uri7 = "https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_100x26.png"
  val uri8 = "https://_ui/responsive/theme-fsx/images/Loader.gif"
  val uri9 = "https://fonts.googleapis.com/css"

  val scn = scenario("place")
    .exec(http("request_7")
      .get("/en_US/")
      .headers(headers_7)
      .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
        .saveAs("requestVerificationToken")))
    .pause(20)
    .exec(http("request_149")
      .post("/en_US/login/submit")
      .headers(headers_149)
      .formParam("myListUrl", "/en_US/my-account/list/viewAllLists")
      .formParam("myListKey", "")
      .formParam("isCheckoutLoginPage", "false")
      .formParam("j_username", "kumarmohan@pragiti.com")
      .formParam("j_password", "12341234")
      .formParam("CSRFToken", "${requestVerificationToken}"))
      //.formParam("CSRFToken", "72f370e1-75ce-4e0f-bfc3-f0d7aaf64826"))
      .pause(20)

      .exec(http("request_299")
        .get("/en_US/FSX/Bar-Equipment/c/3000")
        .headers(headers_7))
      .pause(20)
      .exec(http("req_300")
        .get("/en_US/FSX/Bar-Equipment/Bar-Refrigeration/Glass-Froster/Beverage-Air-GF34L-S-34-Stainless-Steel-Finish-Glass-Froster/p/mp-00002873")
        .headers(headers_7)
        .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
          .saveAs("requestVerificationToken")))
      .pause(30)
      .exec(http("request_583")
        .post("/en_US/cart/addOffer")
        .headers(headers_583)
        .formParam("productCodePost", "offer_6131")
        .formParam("presetPriceValue", "0.0")
        .formParam("qty", "1")
        .formParam("CSRFToken", "${requestVerificationToken}"))
        //.formParam("CSRFToken", "72f370e1-75ce-4e0f-bfc3-f0d7aaf64826"))
        .pause(16)

        .exec(http("request_592")
          .get("/en_US/cart")
          .headers(headers_7))



        .pause(15)
        .exec(http("request_721")
          .get("/en_US/checkout")
          .headers(headers_7)
          .resources(http("request_722")
            .get("/en_US/cart/checkout")
            .headers(headers_7)))

        .pause(20)
        .exec(http("req_305")
          .get("/en_US/checkout/multi/mirakl/delivery-method/choose")
          .headers(headers_7))

        .exec(http("request_845")
          .get("/en_US/checkout/multi/billing-address/add")
          .headers(headers_7))




        .pause(14)
        .exec(http("request_965")
          .get("/en_US/checkout/multi/billing-address/countryAdd?countryIsoCode=US")
          .headers(headers_121))
        .pause(30)
        .exec(http("request_967")
          .get("/en_US/checkout/multi/sop/billingaddressform?countryIsoCode=US&useDeliveryAddress=true")
          .headers(headers_967))
        .pause(7)
        .exec(http("request_968")
          .get("/en_US/checkout/multi/payment-method/add")
          .headers(headers_7)
          .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
            .saveAs("requestVerificationToken")))

        .pause(30)


        .exec(http("request_1089")
          .get("/en_US/checkout/authorize/payment/autoVoidPreviousPayment")
          .headers(headers_121))
        .pause(30)

        .exec(http("request_1120")
          .post("/en_US/checkout/authorize/payment/authorizeCCOrACHPayment")
          .headers(headers_7)
          .formParam("dataValue", "eyJjb2RlIjoiNTBfMl8wNjAwMDUzNEFDQUVGQzFGOTgyMzZEMjI1Qzc0NDhEQ0QwOUZCMUI1RkVFODZCNTkxMUM5ODUwRTkwMTY5MTkzOEYzNzJEMjZFNTdGQkNBMDI2MTU3QzVGMTNBOTY1OEYyMEREQjk4IiwidG9rZW4iOiI5NTY4NjI0NjQyMzc1MjI0NDA0NjAzIiwidiI6IjEuMSJ9")
          .formParam("dataDescriptor", "COMMON.ACCEPT.INAPP.PAYMENT")
          .formParam("cardNumber", "XXXXXXXXXXXX1111")
          .formParam("accountNumber", "")
          .formParam("splitPayment", "false")
          .formParam("CSRFToken", "${requestVerificationToken}"))
          //.formParam("CSRFToken", "72f370e1-75ce-4e0f-bfc3-f0d7aaf64826"))



          setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}


