package computerdatabase

import computerdatabase.Headers.{headers_12, headers_495, headers_578, uri2, uri3}
import io.gatling.http.Predef._
import io.gatling.core.Predef._

object PDP_AddCart {
  val pdp =  exec(http("PDP")
    .get(uri3 + "/FSX/${prodpdp}")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(2)

  val p1pdp =  exec(http("Product_PDP1")
    .get(uri3 + "${s1}/FSX/${purl1}")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(2)
    .exec(http("Product_PDP2")
    .get(uri3 + "${s1}/FSX/${purl2}")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(2)
   .exec(http("Product_PDP3")
    .get(uri3 + "${s1}/FSX/${purl3}")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(2)
  .exec(http("Product_PDP4")
    .get(uri3 + "${s1}/FSX/${purl4}")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
    .pause(2)


    val addcart = exec(http("ATC")
      .post(uri3 + "${s1}/cart/addOffer")
      .headers(headers_578)
      .formParam("productCodePost", "${offer-code1}")
      .formParam("presetPriceValue", "0.0")
      .formParam("qty", "1")
      .formParam("CSRFToken", "${requestVerificationToken}"))
      .pause(2)

}
