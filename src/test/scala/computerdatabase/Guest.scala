package computerdatabase
import computerdatabase.Headers.{headers_6, uri3}

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Guest extends Simulation {

  val httpProtocol = http
    .baseUrl("https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36")

  val headers_2 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")
  val headers_1130 = Map(
    "Accept" -> "image/webp,*/*",
    "Pragma" -> "no-cache",
    "TE" -> "Trailers")

  val headers_3 = Map(
    "Accept" -> "text/css,*/*;q=0.1",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache")

  val headers_15 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache")

  val headers_19 = Map("Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com")

  val headers_25 = Map(
    "Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache")

  val headers_28 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache")

  val headers_140 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_581 = Map(
    "Accept" -> "*/*",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "application/x-www-form-urlencoded; charset=UTF-8",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_715 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_1083 = Map(
    "Accept" -> "text/html, */*; q=0.01",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Pragma" -> "no-cache",
    "X-Requested-With" -> "XMLHttpRequest")

  val headers_1089 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundaryNyMsekz9YkMJiU1W",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_1601 = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3",
    "Accept-Encoding" -> "gzip, deflate, br",
    "Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8",
    "Content-Type" -> "multipart/form-data; boundary=----WebKitFormBoundary4r8hT8GZQfbnolC0",
    "Origin" -> "https://accstorefront.c4f4c56-foodservi1-s1-public.model-t.cc.commerce.ondemand.com",
    "Pragma" -> "no-cache",
    "Upgrade-Insecure-Requests" -> "1")

  val headers_1744 = Map(
    "Content-Type" -> "application/json; charset=UTF-8",
    "Origin" -> "https://jstest.authorize.net")

  val headers_1745 = Map(
    "Access-Control-Request-Headers" -> "content-type",
    "Access-Control-Request-Method" -> "POST",
    "Origin" -> "https://jstest.authorize.net")

  val uri01 = "https://www.google-analytics.com"
  val uri02 = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"
  val uri03 = "https://stats.g.doubleclick.net/r/collect"
  val uri05 = "https://apitest.authorize.net/xml/v1/request.api"
  val uri06 = "https://www.googletagmanager.com/gtm.js"
  val uri07 = "https://www.google.com/ads/ga-audiences"
  val uri08 = "https://fonts.gstatic.com/s/opensans/v17"
  val uri09 = "https://jstest.authorize.net"
  val uri10 = "https://www.paypalobjects.com/webstatic/en_US/i/buttons/PP_logo_h_100x26.png"
  val uri11 = "https://ssl.google-analytics.com"
  val uri12 = "https://fonts.googleapis.com/css"

  val scn = scenario("guestfsx")

        .exec(http("request_2")
          .get("/en_US/")
          .headers(headers_2)
          .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
            .saveAs("requestVerificationToken")))
    .pause(5)

  .exec(http("request_276")
          .get("/en_US/FSX/Kitchen-Equipment/c/1000")
          .headers(headers_2))
    .pause(5)
   .exec(http("request_446")
          .get("/en_US/FSX/Kitchen-Equipment/Mobil-Racks-Carts-Cabinets-Shelving/Dollies/National-Public-Seating-DY-1100-Folding-Chair-Dolly/p/mp-00000016")
   .headers(headers_2))
    .pause(5)
    .exec(http("request_581")
      .post("/en_US/cart/addOffer")
      .headers(headers_581)
      .formParam("productCodePost", "offer_5432")
      .formParam("presetPriceValue", "0.0")
      .formParam("qty", "1")
      .formParam("CSRFToken", "${requestVerificationToken}"))
        .pause(5)
    .exec(http("request_585")
      .get("/en_US/cart/checkout")
      .headers(headers_2))
      .exec(http("request_587")
          .get("/en_US/login/checkout")
          .headers(headers_2))
    .pause(5)

    .exec(http("request_715")
      .post("/en_US/login/checkout/guest")
      .headers(headers_715)
      .formParam("email", "abcscript@www.com")
      .formParam("CSRFToken", "${requestVerificationToken}"))
.pause(5)


    .exec(http("request_1356")
      .post("/en_US/checkout/multi/delivery-address/add")
      .headers(headers_715)
      .formParam("addressId", "")
      .formParam("countryIso", "US")
      .formParam("companyName", "abbc")
      .formParam("industry", "Deli_Market")
      .formParam("titleCode", "mr")
      .formParam("firstName", "abc")
      .formParam("lastName", "xyz")
      .formParam("line1", "abc from abbc")
      .formParam("line2", "")
      .formParam("townCity", "deltek")
      .formParam("regionIso", "US-CA")
      .formParam("state", "")
      .formParam("postcode", "90001")
      .formParam("phone", "(201) 555-7290")
      .formParam("phoneFull", "+12015557290")
      .formParam("CSRFToken", "${requestVerificationToken}"))
      .pause(10)


    .exec(http("Delivery-method-choose")
      .get(uri3 + "/en_US/checkout/multi/mirakl/delivery-method/choose")
      .headers(headers_6))
    .pause(10)

      .exec(http("request_1130")
      .get(uri3 + "/en_US/checkout/multi/sop/billingaddressform?countryIsoCode=US&useDeliveryAddress=true")
      .headers(headers_1130))
    .pause(8)


    .exec(http("request_1601")
      .post("/en_US/checkout/multi/billing-address/add?CSRFToken=${requestVerificationToken}")
      .headers(headers_1601))
      .pause(5)

       .exec(http("request_1763")
          .post("/en_US/checkout/authorize/payment/authorizeCCOrACHPayment")
          .headers(headers_715)
          //.formParam("dataValue", "eyJjb2RlIjoiNTBfMl8wNjAwMDUyMzVDNTA5N0I1MEMyMjIwRkM3MjZCODRGMzVEMzI2OTlFQUY3QzUwMERFNTVBMThDMkQyRUNCNTgwQjM1MjQzMUJDNzc0Qzk3NERGQjQ4MkIxOTFFQzY3QkJCQjQzMDUzIiwidG9rZW4iOiI5NTY5ODI1NzY4NTA4MjgyNjAzNTAxIiwidiI6IjEuMSJ9")
          .formParam("dataDescriptor", "COMMON.ACCEPT.INAPP.PAYMENT")
          .formParam("cardNumber", "XXXXXXXXXXXX1111")
          .formParam("accountNumber", "")
          .formParam("splitPayment", "false")
          .formParam("CSRFToken", "${requestVerificationToken}"))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
