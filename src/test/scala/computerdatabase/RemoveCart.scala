package computerdatabase

import computerdatabase.Headers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object RemoveCart {

  val removeCart = exec(http("request_940")
    .get(uri3 + "/en_US/cart")
    .headers(headers_12)
    .check(regex("""<input type="hidden" name="CSRFToken" value="([^"]*)" />""").saveAs("requestVerificationToken")))
      .pause(2)

 val cart1 =  exec(http("request_943")
    .post(uri3 + "/en_US/cart/update")
    .headers(headers_12)
    .formParam("entryNumber", "0")
    .formParam("productCode", "${pp}")
    .formParam("initialQuantity", "0")
    .formParam("quantity", "0")
    .formParam("CSRFToken", "${requestVerificationToken}"))


}
