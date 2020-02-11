package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import Headers._

object QuickView {
  val qv = exec(http("Click on quickview")
  .get("/en_US/p/${Product}/quickView")
    .headers(headers_300)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""")
      .saveAs("requestVerificationToken")))
    //.check(status.is(200)))
    .pause(20)


  val addtocart = exec(http("Click on addtocart CTA")
    .post("/en_US/cart/addOffer")
    .headers(headers_304)
    .formParam("productCodePost", "offer_5870")
    .formParam("presetPriceValue", "0.0")
    .formParam("qty", "1")
    .formParam("CSRFToken", "${requestVerificationToken}"))
    .pause(20)

}
